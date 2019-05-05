public interface DataManipulate {
    boolean findProductByID();
    boolean findProductByName();

    boolean insertNewProduct();
    Product retreiveProductByID();

    void displayProductByID();
    int displayProductByName();

    boolean deleteProductByID();
}
