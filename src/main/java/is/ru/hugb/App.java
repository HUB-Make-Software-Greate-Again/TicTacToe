package is.ru.hugb;

import static spark.Spark.*;
import org.flywaydb.core.Flyway;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

public class App
{
    private static final String GAME = "tictactoe_instance";

    private static void serve(){
        post("/game", (req, res) -> {
            // If request doesn't have x & y params, return error
            if (req.session().attribute(GAME) == null){
                req.session().attribute(GAME, new TicTacToe());
            }

            int x = 0, y = 0;

            try {
                x = Integer.parseInt(req.queryParams("x"));
                y = Integer.parseInt(req.queryParams("y"));
            } catch (Exception e){
                return String.format("There was an error with the query parameters, expecting x and y as numbers. %s", e.getMessage());
            }

            TicTacToe game = req.session().attribute(GAME);

            try {
                game.doMove(x, y);
            } catch (IllegalArgumentException e){
                return String.format("Illegal move, %s", e.getMessage());
            }

            if (game.gameOver()){
                String response = String.format("Game over, winner is %d", game.winner());
                req.session().attribute(GAME, new TicTacToe());
                return response;
            } 

            return "OK";
        });
    }

    private static Connection getConnection() throws URISyntaxException, SQLException{
        Flyway flyway = new Flyway();
        try{
            String url = System.getenv("DATABASE_URL");

            System.out.println(url);
            URI uri = new URI(url);
            System.out.println(uri.getUserInfo());
            String username = uri.getUserInfo().split(":")[0];
            String password = uri.getUserInfo().split(":")[1];
            url = "jdbc:" + url;
            System.out.println(url);
            flyway.setDataSource(url, username, password);
            flyway.clean();
            flyway.migrate();
            return DriverManager.getConnection(url, username, password);
            
        }
        catch(URISyntaxException e){
            e.printStackTrace();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) throws URISyntaxException, SQLException{
        staticFiles.location("/public");
        port(readPortOrDefault());     
        getConnection();
        serve();   
    }

    static int readPortOrDefault() {
        ProcessBuilder psb = new ProcessBuilder();
        if (psb.environment().get("PORT") != null) {
          return Integer.parseInt(psb.environment().get("PORT"));
        }
        return 4567;
      }
}