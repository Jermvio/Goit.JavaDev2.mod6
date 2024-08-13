import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static String dbUrl = "jdbc:mysql://127.0.0.1:3306/megasoft";
    private static String dbUser = "root";
    private static String dbPass = "1111";

    private static Database instance;
    private Connection conn;

    private Database() {
        try(Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass)) {
            this.conn = conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Database getInstance() {
        if(instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            if (conn.isClosed()) {
                conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            }
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
