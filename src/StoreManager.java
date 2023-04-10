import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StoreManager {

    private static StoreManager instance = null;

    private RemoteDataAdapter dao;

    private ProductView productView = null;
    private LoginScreen loginScreen = null;
    private CheckoutScreen checkoutScreen = null;
    private Connection connection;

    private DataAdapter dataAdapter;


    public ProductView getProductView() {
        return productView;
    }
    public LoginScreen getLoginScreen() {return loginScreen;}
    public CheckoutScreen getCheckoutScreen() {return checkoutScreen;}


    public CheckoutController getCheckoutController() {
        return checkoutController;
    }
    public Connection getConnection() {
        return connection;
    }
    public DataAdapter getDataAdapter() {
        return dataAdapter;
    }




    private ProductController productController = null;
    private LoginController loginController = null;
    private CheckoutController checkoutController;






    public static StoreManager getInstance() {
        if (instance == null)
            instance = new StoreManager("SQLite");
        return instance;
    }

    private User currentUser = null;

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    private void initializeDatabase(Statement stmt) throws SQLException {
        // create the tables and insert sample data here!

        stmt.execute("create table Product (ProductID int PRIMARY KEY, ProductName char(30), Price double, Quantity double)");
        stmt.execute("create table Order (ProductID int PRIMARY KEY, ProductName char(30), Price double, Quantity double)");


    }



    public RemoteDataAdapter getDataAccess() {
        return dao;
    }

    private StoreManager(String db) {
        // do some initialization here!!!
        dao = new RemoteDataAdapter();
        dao.connect();

        productView = new ProductView();
        productController = new ProductController(productView, dao);



        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:store.db");
            Statement stmt = connection.createStatement();
        }
        catch (ClassNotFoundException ex) {
            System.out.println("SQLite is not installed. System exits with error!");
            System.exit(1);
        }

        catch (SQLException ex) {
            System.out.println("SQLite database is not ready. System exits with error!" + ex.getMessage());

            System.exit(2);
        }


        dataAdapter = new DataAdapter(connection);


        loginScreen = new LoginScreen();
        loginController = new LoginController(loginScreen, dataAdapter, dao);

        checkoutScreen = new CheckoutScreen();
        checkoutController = new CheckoutController(checkoutScreen, dataAdapter, dao);


    }






    }


