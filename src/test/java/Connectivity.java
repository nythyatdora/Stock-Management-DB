import java.sql.*;

public class Connectivity {
    private static final String DRIVER_NAME = "org.postgresql.Driver";
    private static final String LOCALHOST = "";
    private static final int PORT_NUMBER = 5432;
    private static final String DATABASE_NAME = "postgres";

    private static final String URL = "jdbc:postgresql://" + LOCALHOST + ":" + PORT_NUMBER + "/" + DATABASE_NAME;
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "";

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private CallableStatement callableStatement;

    public boolean startConnection() {
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

    public boolean stopConnection() {
        try {
            connection.close();
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean executeStatement(String queryString) {
        boolean isSuccess;
        try {
            statement = connection.createStatement();
            isSuccess = statement.execute(queryString);
            statement.close();
            return isSuccess;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ResultSet executeQueryStatement(String queryString) {
        ResultSet resultSet;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryString);

            return resultSet;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int executeUpdateStatement(String queryString) {
        int rowAffected;
        try {
            statement = connection.createStatement();
            rowAffected = statement.executeUpdate(queryString);
            statement.close();

            return rowAffected;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}


