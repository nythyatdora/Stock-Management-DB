import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestLine;
import de.vandermeer.asciithemes.TA_GridThemes;
import de.vandermeer.asciithemes.u8.U8_Grids;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.ArrayList;

public abstract class AbstractBaseCode implements DisplayLayout, CoreProcess, DataManipulate, UpdateOption, MessageLayout {
    private static MetaData metaData;
    private static ArrayList<Product> listOfProducts;

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
        AsciiTable mainLayout = new AsciiTable();

        mainLayout.addRule();
        mainLayout.addRow("[*]\tDisplay","[W|w]\tWrite","[R|r]\tRead","[U|u]\tUpdate","[D|d]\tDelete","[F|f]\tFirst","[P|p]\tPrevious","[N|n]\tNext");
        mainLayout.addRule();
        mainLayout.addRow("[L|l]\tLast","[G|g]\tGoto","[O|o]\tSet Row","[V|v]\tSave","[C|c]\tBack up","[T|t]\tRestore","[H|h]\tHelp","[E|e]\tExit");
        mainLayout.addRule();

        mainLayout.getContext().setWidth(160);
        mainLayout.setTextAlignment(TextAlignment.CENTER);
        mainLayout.getContext().setGrid(U8_Grids.borderDouble());

        System.out.println(mainLayout.render());
    }

    @Override
    public void outputHelpLayout() {
        AsciiTable at = new AsciiTable();
        AsciiTable on = new AsciiTable();
        on.addRule();
        on.addRow("HELP");
        on.addRow("=====================================================================================");

        at.addRow("", "","");
        at.addRow("1.", "Press","[*]    : Display all record of product").setPaddingLeftRight(2);
        at.addRow("2.", "Press","[W|w]  : Add new product").setPaddingLeftRight(2);
        at.addRow("",   "Press","[W|w] -> #proname-unit_price-qty : shortcut for add new product").setPaddingLeftRight(2);
        at.addRow("3.", "Press","[R|r]  : read Content any content").setPaddingLeftRight(2);
        at.addRow("",   "Press","[R|r] -> #proId shortcut for read product by Id").setPaddingLeftRight(2);
        at.addRow("4.", "Press","[U|u]  : Update Data").setPaddingLeftRight(2);
        at.addRow("5.", "Press","[D|d]  : Delete Data").setPaddingLeftRight(2);
        at.addRow("",   "Press","[D|d] -> #proId shortcut for delete product by Id").setPaddingLeftRight(2);
        at.addRow("6.", "Press","[F|f]  : Display First Page").setPaddingLeftRight(2);
        at.addRow("7.", "Press","[P|p]  : Display Previous Page").setPaddingLeftRight(2);
        at.addRow("8.", "Press","[N|n]  : Display Next Page").setPaddingLeftRight(2);
        at.addRow("9.", "Press","[L|l]  : Display Last Page").setPaddingLeftRight(2);
        at.addRow("10.", "Press","[N|n] : Search product by name").setPaddingLeftRight(2);
        at.addRow("11.", "Press","[V|v] : save record to file").setPaddingLeftRight(2);
        at.addRow("12.", "Press","[C|c] : Backup Data").setPaddingLeftRight(2);
        at.addRow("13.", "Press","[T|t] : Restore data").setPaddingLeftRight(2);
        at.addRow("14.", "Press","[H|h] : Help").setPaddingLeftRight(2);
        at.addRow("", "","");
        at.addRule();

        on.getContext().setGridTheme(TA_GridThemes.OUTSIDE);// Cut inside border
        on.getContext().setGrid(U8_Grids.borderDouble());//double border style
        on.setTextAlignment(de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment.CENTER);
        on.getContext().setWidth(87);
        System.out.println(on.render());

        CWC_LongestLine cwc = new CWC_LongestLine();
        at.getRenderer().setCWC(cwc);
        at.getContext().setGridTheme(TA_GridThemes.OUTSIDE);// Cut inside border
        at.getContext().setGrid(U8_Grids.borderDouble());//double border style
        System.out.println(at.render());
    }

    @Override
    public void outputTableDataLayout() {
        displayTableData(metaData.startRow, metaData.currentPage, listOfProducts);
    }

    @Override
    public void outputProductData(Product product) {
        AsciiTable table = new AsciiTable();
        AsciiTable on = new AsciiTable();
        on.addRule();

        on.addRow("TABLE PRODUCT");
        on.addRow("==================================================");

        table.addRow("ID", " : " + product.getProductID());
        table.addRow("Name", " : " + product.getProductName());
        table.addRow("Unit price", " : " + product.getUnitPrice());
        table.addRow("Qty", " : " + product.getQuantity());
        table.addRow("Imported Date", " : " + product.getImportDate());
        table.addRule();

        on.getContext().setGridTheme(TA_GridThemes.OUTSIDE);// Cut inside border
        on.getContext().setGrid(U8_Grids.borderDouble());//double border style
        on.setTextAlignment(de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment.CENTER);
        on.getContext().setWidth(52);
        System.out.println(on.render());

        table.setPaddingRight(3);
        table.setPaddingLeft(1);
        table.getContext().setWidth(52);
        table.getContext().setGridTheme(TA_GridThemes.OUTSIDE);
        table.getContext().setGrid(U8_Grids.borderDouble());
        System.out.println(table.render());
    }

    @Override
    public void displayTableData(int rowSetup, int viewPage, ArrayList<Product> products) {
        if (rowSetup <= 0 || viewPage <= 0) {
            // outputMessageErrorLayout("Input Value Less Than 0!");
            return;
        }

        AsciiTable table = new AsciiTable();
        AsciiTable pagination = new AsciiTable();

        long lastPage = products.size() / rowSetup;
        long temp = products.size() % rowSetup;

        if (temp != 0) {
            lastPage++;
        }

        if (viewPage > lastPage) {
            // outputMessageErrorLayout("View Page Bigger Than Total Page!");
            return;
        }

        table.addRule();
        table.addRow("ID", "NAME", "UNIT PRICE", "QTY", "IMPORT DATE");
        table.addRule();

        if (lastPage == viewPage) {
            for (int i = (viewPage - 1) * rowSetup; i < products.size(); i++) {
                Product product = products.get(i);

                table.addRow(product.getProductID(), product.getProductName(), product.getUnitPrice(),
                        product.getQuantity(), product.getImportDate());
                table.addRule();
            }
        }
        else {
            int t = viewPage * rowSetup;
            for (int j = t - rowSetup; j < t; j++) {
                Product product = products.get(j);

                table.addRow(product.getProductID(), product.getProductName(), product.getUnitPrice(),
                        product.getQuantity(), product.getImportDate());
                table.addRule();
            }
        }

        table.setTextAlignment(de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment.CENTER);
        table.getContext().setGrid(U8_Grids.borderDouble());

        pagination.addRule();
        pagination.addRow("Page : " + viewPage + " of " + lastPage, " Total Record : " + products.size());
        pagination.addRule();

        pagination.setTextAlignment(de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment.CENTER);
        pagination.getContext().setGrid(U8_Grids.borderDoubleLight());
        pagination.getContext().setGridTheme(TA_GridThemes.OUTSIDE);

        System.out.println(table.render(100));
        System.out.println(pagination.render(100));
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
                        updateAllOption(searchProduct);
                        isContinue = false;
                        break;

                    case UPDATE_NAME:
                        updateNameOption(searchProduct);
                        isContinue = false;
                        break;

                    case UPDATE_UNIT_PRICE:
                        updateUnitPriceOption(searchProduct);
                        isContinue = false;
                        break;

                    case UPDATE_QUANTITY:
                        updateQuantityOption(searchProduct);
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
        AsciiTable table = new AsciiTable();

        table.addRule();
        table.addRow("[1] - All", "[2] - Name", "[3] - Quantity", "[4] - Unit Price", "[5] - Back to Menu");
        table.addRule();
        table.getContext().setGridTheme(TA_GridThemes.FULL);
        table.setTextAlignment(TextAlignment.CENTER);
        System.out.println(table.render(110));
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
    public void updateAllOption(Product product) {
        String productName;
        int productQuantity;
        double productUnitPrice;

        System.out.println("======== UPDATE PRODUCT ========");
        productName = TextFieldConsole.readStringType("[NEW] Product Name       : ");
        productQuantity = TextFieldConsole.readIntegerType("[NEW] Product Quantity   : ");
        productUnitPrice = TextFieldConsole.readDoubleType("[NEW] Product Unit-Price : ");

        product.setProductName(productName);
        product.setQuantity(productQuantity);
        product.setUnitPrice(productUnitPrice);

        System.out.println();
        outputProductData(product);
        System.out.println();
    }

    @Override
    public void updateNameOption(Product product) {

    }

    @Override
    public void updateQuantityOption(Product product) {

    }

    @Override
    public void updateUnitPriceOption(Product product) {

    }
    // End UpdateOption

    @Override
    public void outputMessageLayout(String message, int type) {

    }
}
