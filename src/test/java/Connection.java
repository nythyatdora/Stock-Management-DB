import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
     static java.sql.Connection con = null;

    public boolean connectToDataBase() {

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/Stock", "postgres", "1609");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean closeConnection() {
        try {
            con.close();
            return true;
        } catch (SQLException e) {
           return false;
        }


    }


}