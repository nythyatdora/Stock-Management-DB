import java.sql.ResultSet;
import java.sql.SQLException;

public class MetaData {
    public int setupRow;
    public int currentPage;

    MetaData() {
        this.setupRow = 10;
        this.currentPage = 1;
    }

    MetaData(int setupRow, int currentPage) {
        this.setupRow = setupRow;
        this.currentPage = currentPage;
    }

    public static MetaData convertToMetaData(ResultSet resultSet) throws SQLException, NullPointerException {
        resultSet.next();
        return new MetaData(resultSet.getInt("start_row"), resultSet.getInt("current_page"));
    }
}
