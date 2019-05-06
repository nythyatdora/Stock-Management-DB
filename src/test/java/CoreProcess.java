import java.sql.Connection;
import java.util.ArrayList;

public interface CoreProcess {
    ArrayList<Product> readDataFromSourceProcess();
    void saveDataToSourceProcess();
    boolean backupDataToSourceProcess(Connection connection);
    boolean restoreDataToSourceProcess(Connection connection);

    void moveToFirstProcess();
    void moveToLastPageProcess();
    void moveToPreviousPageProcess();
    void moveToNextPageProcess();

    void setRowProcess();
    void gotoDataProcess();
}