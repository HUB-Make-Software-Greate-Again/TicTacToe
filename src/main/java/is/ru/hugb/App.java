import static spark.Spark.*;
import is.ru.hugb.TicTacToe;

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

            int x = Integer.parseInt(req.queryParams("x"));
            int y = Integer.parseInt(req.queryParams("y"));

            TicTacToe game = req.session().attribute(GAME);

            // try
            game.doMove(x, y);
            // catch, return illegal move response

            // Return gameover respone
            if (game.gameOver()){
                return "done";
            } 

            // Return everything's ok response
            return "foo";
        });

        post("/reset", (req, res) -> {
            req.session().attribute(GAME, new TicTacToe());

            res.redirect("/");
            return res;
        });
    }
}