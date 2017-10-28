package is.ru.hugb;

import org.flywaydb.core.Flyway;
import java.sql.*;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Wrapper for DB connection
 */
class DbWrapper
{
    private Connection conn = null;

    public DbWrapper(String dns){
        try {
            URI uri = new URI(dns);
            String username = uri.getUserInfo().split(":")[0];
            String password = uri.getUserInfo().split(":")[1];
            String url = "jdbc:postgresql://" + uri.getHost() + ':' + uri.getPort() + uri.getPath();
            if (!url.contains("localhost")) url += "?sslmode=require";
            this.migrate(url, username, password);
            this.conn = DriverManager.getConnection(url, username, password);
        }
        catch(URISyntaxException e) {
            e.printStackTrace();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(int winner){
        String query = "INSERT INTO results(sid, created) VALUES(?, now());";
        try (PreparedStatement stmt = this.conn.prepareStatement(query)){
            stmt.setInt(1, winner);
            stmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void migrate(String url, String user, String pass){
        Flyway flyway = new Flyway();
        flyway.setDataSource(url, user, pass);
        // flyway.clean();
        flyway.migrate();
    }
}