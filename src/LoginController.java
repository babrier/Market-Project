import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener {
    private LoginScreen loginScreen;
    private DataAdapter dataAdapter;
    private DataAccess myDAO;





    public LoginController(LoginScreen loginScreen, DataAdapter dataAdapter, DataAccess dao) {
        this.loginScreen = loginScreen;
        this.dataAdapter = dataAdapter;
        this.loginScreen.getBtnLogin().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        UserModel userModel = new UserModel();
        if (e.getSource() == loginScreen.getBtnLogin()) {
            String username = loginScreen.getTxtUserName().getText().trim();
            String password = loginScreen.getTxtPassword().getText().trim();

            User user = dataAdapter.loadUser(username, password);
            //userModel.UserName = user.getUserName();
            //userModel.Password = user.getPassword();
            //myDAO.loadUser(userModel);



            if (user == null) {
                JOptionPane.showMessageDialog(null, "This user does not exist!");
            }
            else {
                StoreManager.getInstance().setCurrentUser(user);
                this.loginScreen.setVisible(false);
                if (user.isManager()) {

                    StoreManager.getInstance().getProductView().setVisible(true);
                }
                else {
                    StoreManager.getInstance().getCheckoutScreen().setVisible(true);

                }
                }
            }
        }
    }

