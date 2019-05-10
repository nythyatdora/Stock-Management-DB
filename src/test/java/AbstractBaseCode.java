import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class AbstractBaseCode  implements DisplayLayout, CoreProcess, DataManipulate, UpdateOption {
    // DisplayLayout
    {

        try {
            Connection con=new Connection();
            con.connectToDataBase();
            Statement st= Connection.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void outputWelcomeLayout() {

    }

    @Override
    public void outputLogoLayout() {

    }

    @Override
    public void outputLoadingLayout() {

    }

    @Override
    public void outputMainLayout() {

    }

    @Override
    public void outputHelpLayout() {

    }

    @Override
    public void outputTableDataLayout() {

    }

    @Override
    public void outputProductData(Product product) {

    }

    @Override
    public void displayTableData(int startRow, int viewPage, ArrayList<Product> products) {

    }

    @Override
    public void writeDataLayout() {

    }

    @Override
    public void readDataLayout() {

    }

    @Override
    public void searchDataLayout() {

    }

    @Override
    public void deleteDataLayout() {

    }

    @Override
    public void updataDataLayout() {

    }

    @Override
    public void saveDataToSourceLayout() {

    }

    @Override
    public void backupDataToSourceLayout() {

    }

    @Override
    public void restoreDataToSourceLayout() {

    }

    @Override
    public void moveToFirstPageLayout() {

    }

    @Override
    public void moveToLastPageLayout() {

    }

    @Override
    public void moveToPreviousPageLayout() {

    }

    @Override
    public void moveToNextPageLayout() {

    }

    @Override
    public void gotoDataLayout() {

    }

    @Override
    public void setRowLayout() {

    }

    @Override
    public void exitProgramLayout() {

    }

    @Override
    public void outputMessageLayout(String message) {

    }

    @Override
    public void outputMessageErrorLayout(String message) {

    }

    @Override
    public void outputUpdateOptionLayout() {

    }
    // END DisplayLayout

    // CoreProcess
    @Override
    public ArrayList<Product> readDataFromSourceProcess() {
        return null;
    }

    @Override
    public void saveDataToSourceProcess() {

    }

    @Override
    public boolean backupDataToSourceProcess() {
        return false;
    }

    @Override
    public boolean restoreDataToSourceProcess() {
        return false;
    }

    @Override
    public void moveToFirstProcess(int rowSetup, ArrayList<Product> products) {

    }

    @Override
    public void moveToLastPageProcess(int rowSetup, ArrayList<Product> products) {

    }

    @Override
    public void moveToPreviousPageProcess(int rowSetup, ArrayList<Product> products) {

    }

    @Override
    public void moveToNextPageProcess(int rowSetup, ArrayList<Product> products) {

    }

    @Override
    public void setRowProcess() {

    }

    @Override
    public void gotoDataProcess(int rowSetup, ArrayList<Product> products) {

    }
    // END CoreProcess

    // DataManipulate
    @Override
    public boolean findProductByID() {
        return false;
    }

    @Override
    public boolean findProductByName() {
        return false;
    }

    @Override
    public boolean insertNewProduct() {
        return false;
    }

    @Override
    public Product retreiveProductByID() {
        return null;
    }

    @Override
    public void displayProductByID() {

    }

    @Override
    public int displayProductByName() {
        return 0;
    }

    @Override
    public boolean deleteProductByID() {
        return false;
    }
}
