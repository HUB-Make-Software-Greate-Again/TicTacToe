package is.ru.hugb;

import static spark.Spark.*;
import org.json.JSONObject;

/**
 * Main class of the application
 */
public class App
{
    /**
     * String to identify a session's game
     */
    private static final String GAME = "tictactoe_instance";

    /**
     * String to identify error key in JSON response
     */
    private static final String ERROR = "error";

    /**
     * String to identify winner key in JSON response
     */
    private static final String WINNER = "winner";

    /**
     * Start spark serve, lists spark routes
     */
    private static void serve(){
        staticFiles.location("/public");
        DbWrapper db = new DbWrapper(System.getenv("DATABASE_URL"));

        post("/game", (req, res) -> {
            JSONObject response = new JSONObject();
            res.type("application/json");
            TicTacToe game = req.session().attribute(GAME);

            if (game == null || game.gameOver()){
                res.status(400);
                response.put(ERROR, String.format("A new game has not been started"));
                return response.toString();
            }

            int x = 0, y = 0;

            try {
                x = Integer.parseInt(req.queryParams("x"));
                y = Integer.parseInt(req.queryParams("y"));
            } catch (Exception e){
                res.status(422);
                response.put(ERROR, String.format("There was an error with the query parameters, expecting x and y as numbers. %s", e.getMessage()));
                return response.toString();
            }

            try {
                game.doMove(x, y);
            } catch (IllegalArgumentException e){
                res.status(422);
                response.put(ERROR, String.format("Illegal move, %s", e.getMessage()));
                return response.toString();
            }

            if (game.gameOver()){
                response.put(WINNER, game.winner());
                db.insert(game.winner());
                return response.toString();
            } 

            return response.toString();
        });

        post("/reset", (req, res) -> {
            req.session().attribute(GAME, new TicTacToe());

            return "OK";
        });

        get("/javadoc", (req, res) -> {
            res.redirect("javadoc/");

            return "";
        });
    }
    
    /**
     * Start spark server
     * @param args Doesn't use args 
     */
    public static void main(String[] args) {
        port(readPortOrDefault());     
        serve();   
    }

    /**
     * Get local or heroku port, depending on which environment is being run
     * @return int - 4567 for local
     */
    static int readPortOrDefault() {
        ProcessBuilder psb = new ProcessBuilder();
        if (psb.environment().get("PORT") != null) {
          return Integer.parseInt(psb.environment().get("PORT"));
        }
        return 4567;
      }
}