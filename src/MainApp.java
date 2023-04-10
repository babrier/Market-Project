import javax.swing.*;

public class MainApp {
   public static void main(String[] args) {
   
      DataAccess dao = StoreManager.getInstance().getDataAccess();
   
      dao.connect();
   
   
      StoreManager.getInstance().getLoginScreen().setVisible(true);
   
   }
}
