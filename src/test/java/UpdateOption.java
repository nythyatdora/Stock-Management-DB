public interface UpdateOption {
    int UPDATE_ALL = 1;
    int UPDATE_NAME = 2;
    int UPDATE_QUANTITY = 3;
    int UPDATE_UNIT_PRICE = 4;
    int RETURN_TO_MAIN = 5;

    void updateAllOption(Product product);
    void updateNameOption(Product product);
    void updateQuantityOption(Product product);
    void updateUnitPriceOption(Product product);
}
