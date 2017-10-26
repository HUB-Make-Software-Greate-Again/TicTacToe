package is.ru.hugb;

import static spark.Spark.*;
import org.json.JSONObject;

public class App
{
    private static final String GAME = "tictactoe_instance";

    public static void main(String[] args){
        staticFiles.location("/public");
        port(readPortOrDefault());        
        
        post("/game", (req, res) -> {
            // If request doesn't have x & y params, return error
            if (req.session().attribute(GAME) == null){
                req.session().attribute(GAME, new TicTacToe());
            }
            JSONObject response = new JSONObject();
            res.type("application/json");

            int x = 0, y = 0;

            try {
                x = Integer.parseInt(req.queryParams("x"));
                y = Integer.parseInt(req.queryParams("y"));
            } catch (Exception e){
                res.status(422);
                response.put("error", String.format("There was an error with the query parameters, expecting x and y as numbers. %s", e.getMessage()));
                return response.toString();
            }

            TicTacToe game = req.session().attribute(GAME);

            try {
                game.doMove(x, y);
            } catch (IllegalArgumentException e){
                res.status(422);
                response.put("error", String.format("Illegal move, %s", e.getMessage()));
                return response.toString();
            }

            response.put("status", "ok");

            if (game.gameOver()){
                response.put("winner", game.winner());
                req.session().attribute(GAME, new TicTacToe());
            } 

            return response.toString();
        });

        post("/reset", (req, res) -> {
            req.session().attribute(GAME, new TicTacToe());
            return "foo";
        });
    }

    static int readPortOrDefault() {
        ProcessBuilder psb = new ProcessBuilder();
        if (psb.environment().get("PORT") != null) {
          return Integer.parseInt(psb.environment().get("PORT"));
        }
        return 4567;
      }
}