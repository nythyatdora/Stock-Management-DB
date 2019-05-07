import java.util.ArrayList;

public interface CoreProcess {
    ArrayList<Product> readDataFromSourceProcess();
    void saveDataToSourceProcess();
    boolean backupDataToSourceProcess();
    boolean restoreDataToSourceProcess();

    void moveToFirstProcess();
    void moveToLastPageProcess();
    void moveToPreviousPageProcess();
    void moveToNextPageProcess();

    void setRowProcess();
    void gotoDataProcess();
}