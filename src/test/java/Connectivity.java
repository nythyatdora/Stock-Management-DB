import java.sql.*;

public class Connectivity {
    private static final String DRIVER_NAME = "org.postgresql.Driver";
    private static final String LOCALHOST = "localhost";
    private static final int PORT_NUMBER = 5432;
    private static final String DATABASE_NAME = "TestProject";

    private static final String URL = "jdbc:postgresql://" + LOCALHOST + ":" + PORT_NUMBER + "/" + DATABASE_NAME;
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "";

    private static Connection connection;

    public static boolean startConnection() {
        try {
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if(connection != null)
                return true;
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean stopConnection() {
        try {
            connection.close();
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean executeStatement(String queryString) throws SQLException {
        boolean isSuccess;
        Statement statement;
        statement = connection.createStatement();
        isSuccess = statement.execute(queryString);
        return isSuccess;
    }

    public ResultSet executeQueryStatement(String queryString, int cursorType, int mode) throws SQLException {
        Statement statement;
        ResultSet resultSet;
        statement = connection.createStatement(cursorType, mode);
        resultSet = statement.executeQuery(queryString);
        return resultSet;
    }

    public int executeUpdateStatement(String queryString) throws SQLException {
        int rowAffected;
        Statement statement;
        statement = connection.createStatement();
        rowAffected = statement.executeUpdate(queryString);
        return rowAffected;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        stopConnection();
    }
}


