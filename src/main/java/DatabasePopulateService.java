import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("src/sql/populate_db.sql"))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String sqlCommands = sb.toString();

        Connection conn = Database.getInstance().getConnection();

        try (Statement statement = conn.createStatement()) {
            String[] sqlStatements = sqlCommands.split(";");
            for (String sql : sqlStatements) {
                if (!sql.trim().isEmpty()) {
                    statement.execute(sql.trim());
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
