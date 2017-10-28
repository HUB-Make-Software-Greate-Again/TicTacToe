package is.ru.hugb;

import static spark.Spark.*;
import org.json.JSONObject;
import org.flywaydb.core.Flyway;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

public class App
{
    private static final String GAME = "tictactoe_instance";

    private static void serve(){
        DbWrapper db = new DbWrapper(System.getenv("DATABASE_URL"));

        post("/game", (req, res) -> {
            JSONObject response = new JSONObject();
            res.type("application/json");
            TicTacToe game = req.session().attribute(GAME);

            if (game == null || game.gameOver()){
                res.status(400);
                response.put("Error", String.format("A new game has not been started"));
                return response.toString();
            }

            int x = 0, y = 0;

            try {
                x = Integer.parseInt(req.queryParams("x"));
                y = Integer.parseInt(req.queryParams("y"));
            } catch (Exception e){
                res.status(422);
                response.put("error", String.format("There was an error with the query parameters, expecting x and y as numbers. %s", e.getMessage()));
                return response.toString();
            }

            try {
                game.doMove(x, y);
            } catch (IllegalArgumentException e){
                res.status(422);
                response.put("error", String.format("Illegal move, %s", e.getMessage()));
                return response.toString();
            }

            if (game.gameOver()){
                response.put("winner", game.winner());
                return response.toString();
            } 

            return response.toString();
        });

        post("/reset", (req, res) -> {
            req.session().attribute(GAME, new TicTacToe());

            return "OK";
        });
    }
    
    public static void main(String[] args) throws URISyntaxException, SQLException{
        staticFiles.location("/public");
        port(readPortOrDefault());     
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