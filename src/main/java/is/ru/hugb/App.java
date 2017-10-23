import static spark.Spark.*;

public class App
{
    private static final String SESSION_ID = "game_id";

    public static void main(String[] args){
        staticFileLocation("/public");

        get("/", (req, res) -> {
            req.session().attribute(SESSION_ID, "foo");
            return res;
        });

        get("/game", (req, res) -> {
            return req.session().attribute(SESSION_ID);
        });
    }
}