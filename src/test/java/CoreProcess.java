import java.util.ArrayList;

public interface CoreProcess {
    ArrayList<Product> readDataFromSourceProcess();
    void saveDataToSourceProcess();
    boolean backupDataToSourceProcess();
    boolean restoreDataToSourceProcess();

    void moveToFirstProcess(int rowSetup, ArrayList<Product> products);
    void moveToLastPageProcess(int rowSetup, ArrayList<Product> products);
    void moveToPreviousPageProcess(int rowSetup, ArrayList<Product> products);
    void moveToNextPageProcess(int rowSetup, ArrayList<Product> products);

    void setRowProcess();

    void gotoDataProcess(int rowSetup, ArrayList<Product> products);
}