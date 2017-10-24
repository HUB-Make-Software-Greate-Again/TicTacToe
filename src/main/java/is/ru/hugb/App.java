package is.ru.hugb;

import static spark.Spark.*;

public class App
{
    private static final String GAME = "tictactoe_instance";

    public static void main(String[] args){
        staticFiles.location("/public");
        
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
}