import java.util.ArrayList;

public abstract class AbstractBaseCode implements DisplayLayout, CoreProcess, DataManipulate, UpdateOption, MessageLayout {
    // DisplayLayout
    @Override
    public void outputWelcomeLayout() {

    }

    @Override
    public void outputLogoLayout() {
        String[] logoText = {
                "███████╗████████╗ ██████╗  ██████╗██╗  ██╗ ",
                "██╔════╝╚══██╔══╝██╔═══██╗██╔════╝██║ ██╔╝",
                "███████╗   ██║   ██║   ██║██║     █████╔╝",
                "╚════██║   ██║   ██║   ██║██║     ██╔═██╗",
                "███████║   ██║   ╚██████╔╝╚██████╗██║  ██╗",
                "╚══════╝   ╚═╝    ╚═════╝  ╚═════╝╚═╝  ╚═╝",

                "███╗   ███╗ █████╗ ███╗   ██╗ █████╗  ██████╗ ███████╗███╗   ███╗███████╗███╗   ██╗████████╗",
                "████╗ ████║██╔══██╗████╗  ██║██╔══██╗██╔════╝ ██╔════╝████╗ ████║██╔════╝████╗  ██║╚══██╔══╝",
                "██╔████╔██║███████║██╔██╗ ██║███████║██║  ███╗█████╗  ██╔████╔██║█████╗  ██╔██╗ ██║   ██║",
                "██║╚██╔╝██║██╔══██║██║╚██╗██║██╔══██║██║   ██║██╔══╝  ██║╚██╔╝██║██╔══╝  ██║╚██╗██║   ██║",
                "██║ ╚═╝ ██║██║  ██║██║ ╚████║██║  ██║╚██████╔╝███████╗██║ ╚═╝ ██║███████╗██║ ╚████║   ██║",
                "╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝     ╚═╝╚══════╝╚═╝  ╚═══╝   ╚═╝",

                "██╗    ██╗██╗████████╗██╗  ██╗    ██████╗ ██████╗   ██╗   ██╗ ██╗",
                "██║    ██║██║╚══██╔══╝██║  ██║    ██╔══██╗██╔══██╗  ██║   ██║███║",
                "██║ █╗ ██║██║   ██║   ███████║    ██║  ██║██████╔╝  ██║   ██║╚██║",
                "██║███╗██║██║   ██║   ██╔══██║    ██║  ██║██╔══██╗  ╚██╗ ██╔╝ ██║",
                "╚███╔███╔╝██║   ██║   ██║  ██║    ██████╔╝██████╔╝██╗╚████╔╝  ██║",
                " ╚══╝╚══╝ ╚═╝   ╚═╝   ╚═╝  ╚═╝    ╚═════╝ ╚═════╝ ╚═╝ ╚═══╝   ╚═╝"
        };

        CommonMethod.printlnStrings(logoText);
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
        char choice;
        boolean hasInserted = false;
        boolean toContinue = true;
        Product insertProduct;
        int id = -1;

        System.out.println("======== INSERT NEW PRODUCT =========");
        System.out.println("[NEW] Product ID         : " + id);
        String productName = TextFieldConsole.readStringType("[NEW] Product Name       : ");
        int productQuantity = TextFieldConsole.readIntegerType("[NEW] Product Quantity   : ");
        double productUnitPrice = TextFieldConsole.readDoubleType("[NEW] Product Unit-Price : ");
        String importDate = CommonMethod.formalDateFormat();

        insertProduct = new Product(id, productName, productUnitPrice, productQuantity, importDate);

        System.out.println();
        outputProductData(insertProduct);
        System.out.println();

        do {
            choice = TextFieldConsole.readCharType("Are you sure that you want to insert the product? [Y|y] or [N|n] : ");
            System.out.println();
            switch (choice) {
                case 'Y':
                case 'y':
                    hasInserted = insertNewProduct();
                    toContinue = false;
                    break;

                case 'N':
                case 'n':
                    toContinue = false;
                    break;

                default:
                    outputMessageLayout("Invalid Input!", MessageLayout.TYPE_DANGER);
                    break;
            }
        } while(toContinue);

        if(!hasInserted) {
            outputMessageLayout("Process Canceled!", MessageLayout.TYPE_WARNING);
        }
        else {
            outputMessageLayout("Product with ID : " + id + " was added successfully!", MessageLayout.TYPE_SUCCESS);
        }
    }

    @Override
    public void readDataLayout() {
        int productID;
        boolean isFound;

        System.out.println("======== READ PRODUCT =========");
        productID = TextFieldConsole.readIntegerType("Input the ID of Product : ");
        isFound = findProductByID();

        System.out.println();

        if(!isFound) {
            outputMessageLayout("Product not found!", MessageLayout.TYPE_WARNING);
        }
        else {
            displayProductByID();
        }
    }

    @Override
    public void searchDataLayout() {
        String productName;
        boolean isFound;
        int searchResult = -1;

        productName = TextFieldConsole.readStringType("Input the Name of Product : ");
        isFound = findProductByName();

        if(!isFound) {
            outputMessageLayout("Product Not Found!", MessageLayout.TYPE_WARNING);
        }
        else {
            searchResult = displayProductByName();
        }

        System.out.println("Product Found for [" + productName + "] : " + searchResult);
    }

    @Override
    public void deleteDataLayout() {
        int productID;
        char choice;
        boolean isFound;
        boolean hasDeleted = false;
        boolean toContinue = true;

        System.out.println("======= DELETE PRODUCT ========");
        productID = TextFieldConsole.readIntegerType("Input the ID of Product : ");
        isFound = findProductByID();
        System.out.println();

        if(!isFound) {
            outputMessageLayout("Product Not Found!", MessageLayout.TYPE_WARNING);
        }
        else {
            displayProductByID();
            System.out.println();

            do {
                choice = TextFieldConsole.readCharType("Are you sure that you want to delete this record? [Y|y] or [N|n] : ");
                switch (choice) {
                    case 'Y':
                    case 'y':
                        hasDeleted = deleteProductByID();
                        toContinue = false;
                        break;

                    case 'N':
                    case 'n':
                        toContinue = false;
                        break;
                }
            }
            while (toContinue);

            if (!hasDeleted) {
                System.out.println();
                outputMessageLayout("Process Canceled!", MessageLayout.TYPE_WARNING);
            }
            else {
                outputMessageLayout("Product with ID : " + productID + " was deleted successfully!", MessageLayout.TYPE_SUCCESS);
            }
        }
    }

    @Override
    public void updataDataLayout() {
        int productID;
        int choice;

        boolean isFound;
        boolean hasUpdated = false;
        boolean isContinue = true;

        Product searchProduct;

        System.out.println("======= UPDATE PRODUCT ========");
        productID = TextFieldConsole.readIntegerType("Input the ID of Product : ");
        isFound = findProductByID();

        if(!isFound) {
            System.out.println();
            outputMessageLayout("Product Not Found!", MessageLayout.TYPE_WARNING);
            return;
        }
        else {
            searchProduct = retreiveProductByID();

            System.out.println();
            outputProductData(searchProduct);
            System.out.println();

            do {
                System.out.println("What do you want to update?");
                outputUpdateOptionLayout();
                choice = TextFieldConsole.readIntegerType("Option : ");

                switch (choice) {
                    case UPDATE_ALL:
                        updateAllOption();
                        isContinue = false;
                        break;

                    case UPDATE_NAME:
                        updateNameOption();
                        isContinue = false;
                        break;

                    case UPDATE_UNIT_PRICE:
                        updateUnitPriceOption();
                        isContinue = false;
                        break;

                    case UPDATE_QUANTITY:
                        updateQuantityOption();
                        isContinue = false;
                        break;

                    case RETURN_TO_MAIN:
                        isContinue = false;
                        break;

                    default:
                        System.out.println();
                        outputMessageLayout("Invalid Input!", MessageLayout.TYPE_DANGER);
                        System.out.println();
                        break;
                }
            }
            while (isContinue);
        }

        if(!hasUpdated) {
            System.out.println();
            outputMessageLayout("Process Canceled!", MessageLayout.TYPE_WARNING);
            System.out.println();
        }
        else {
            System.out.println();
            outputMessageLayout("Product with ID : " + productID + " was updated successfully!", MessageLayout.TYPE_SUCCESS);
        }
    }

    @Override
    public void saveDataToSourceLayout() {
        saveDataToSourceProcess();
    }

    @Override
    public void backupDataToSourceLayout() {
        backupDataToSourceProcess();
    }

    @Override
    public void restoreDataToSourceLayout() {
        restoreDataToSourceProcess();
    }

    @Override
    public void moveToFirstPageLayout() {
        moveToFirstProcess();
    }

    @Override
    public void moveToLastPageLayout() {
        moveToLastPageProcess();
    }

    @Override
    public void moveToPreviousPageLayout() {
        moveToPreviousPageProcess();
    }

    @Override
    public void moveToNextPageLayout() {
        moveToNextPageProcess();
    }

    @Override
    public void gotoDataLayout() {
        gotoDataProcess();
    }

    @Override
    public void setRowLayout() {
        setRowProcess();
    }

    @Override
    public void exitProgramLayout() {
        System.exit(0);
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
    public void moveToFirstProcess() {

    }

    @Override
    public void moveToLastPageProcess() {

    }

    @Override
    public void moveToPreviousPageProcess() {

    }

    @Override
    public void moveToNextPageProcess() {

    }

    @Override
    public void setRowProcess() {

    }

    @Override
    public void gotoDataProcess() {

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
    public void displayProductByID() {}

    @Override
    public int displayProductByName() {
        return 0;
    }

    @Override
    public boolean deleteProductByID() {
        return false;
    }
    // End DataManipulate

    // UpdateOption
    @Override
    public void updateAllOption() {

    }

    @Override
    public void updateNameOption() {

    }

    @Override
    public void updateQuantityOption() {

    }

    @Override
    public void updateUnitPriceOption() {

    }
    // End UpdateOption

    @Override
    public void outputMessageLayout(String message, int type) {

    }
}
