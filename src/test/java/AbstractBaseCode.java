import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciithemes.u8.U8_Grids;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.ArrayList;

public abstract class AbstractBaseCode implements DisplayLayout, CoreProcess, DataManipulate, UpdateOption {
    // DisplayLayout
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
        AsciiTable mainLayout = new AsciiTable();
        mainLayout.addRule();
        mainLayout.addRow(null, null, null, null, null, "Main");
        mainLayout.addRule();
        mainLayout.addRow(null, null, null, null, null, "---");
        mainLayout.addRule();
//        mainLayout.addRow("[ ]", null, null, null, null,"[ ]");
//        mainLayout.addRule();
//        mainLayout.addRow(null, null, " ", " ", " ", "---");
////        mainLayout.addRule();
////        mainLayout.addRow(" ", null, null, " "," ", " ");
////        mainLayout.addRule();
////        mainLayout.addRow(" ", " ", " ", "", "", "");
////        mainLayout.addRule();
////        mainLayout.addRow(" ", " ", " ", "", "", "");
//        mainLayout.addRule();
        mainLayout.getContext().setWidth(160);
        mainLayout.setTextAlignment(TextAlignment.CENTER);
        mainLayout.getContext().setGrid(U8_Grids.borderDouble());
        System.out.println(mainLayout.render(80));


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
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow(null, null, null, "Choose Table To Restore").setTextAlignment(TextAlignment.CENTER);
        at.addRule();
        at.addRow("ID", "Recovery", "Date", "Option").setTextAlignment(TextAlignment.CENTER);
        at.addRule();
        at.addRow("-", "-", "-", "-").setTextAlignment(TextAlignment.CENTER);
        at.addRow("-", "-", "-", "-").setTextAlignment(TextAlignment.CENTER);
        at.addRow("-", "-", "-", "-").setTextAlignment(TextAlignment.CENTER);
        at.addRow("-", "-", "-", "-").setTextAlignment(TextAlignment.CENTER);
        at.addRow("-", "-", "-", "-").setTextAlignment(TextAlignment.CENTER);
        at.addRow("-", "-", "-", "-").setTextAlignment(TextAlignment.CENTER);
        at.addRow("-", "-", "-", "-").setTextAlignment(TextAlignment.CENTER);
        at.addRow("-", "-", "-", "-").setTextAlignment(TextAlignment.CENTER);
        at.addRow("-", "-", "-", "-").setTextAlignment(TextAlignment.CENTER);
        at.addRow("-", "-", "-", "-").setTextAlignment(TextAlignment.CENTER);
        at.addRow("-", "-", "-", "-").setTextAlignment(TextAlignment.CENTER);
        at.addRow("-", "-", "-", "-").setTextAlignment(TextAlignment.CENTER);
        at.addRule();
        at.addRow(null, null, null, "Total:_________   ").setTextAlignment(TextAlignment.JUSTIFIED_RIGHT);
        at.addRule();
        String rend = at.render();
        System.out.println(rend);


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
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow("Title");
        at.addRule();
        at.addRow("Message............");
        at.addRule();
        at.setTextAlignment(TextAlignment.CENTER);
        System.out.println(at.render());


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
