public interface DataAccess {
    void connect();

    void saveProduct(ProductModel product);

    ProductModel loadProduct(int productID);

    void saveOrder(OrderModel order);

    void loadUser(UserModel user);



}
