import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    private static java.sql.Connection con = null;

    public void connectToDataBase() {

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/Stock", "postgres", "1609");
            System.out.println("sucessfully open");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            con.close();
            System.out.println("conection close");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        new Connection().connectToDataBase();
        new Connection().closeConnection();
    }
}