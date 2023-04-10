import javax.swing.*;
import java.awt.*;

public class LoginScreen extends JFrame {
    private JTextField txtUserName = new JTextField(10);
    private JTextField txtPassword = new JTextField(10);
    private JButton    btnLogin    = new JButton("Login");

    public JButton getBtnLogin() {
        return btnLogin;
    }

    public JTextField getTxtPassword() {
        return txtPassword;
    }

    public JTextField getTxtUserName() {
        return txtUserName;
    }

    public LoginScreen() {

        this.setSize(300, 400);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.getContentPane().setBackground(Color.GRAY);

        this.getContentPane().add(Box.createVerticalStrut(10)); // Add some spacing at the top
        JLabel label1 = new JLabel("JAVAJAVAJAVA");
        JLabel label2 = new JLabel("JAVAJAVAJAVA");
        JLabel label3 = new JLabel("            JAVA");
        JLabel label4 = new JLabel("           JAVA");
        JLabel label5 = new JLabel("            JAVA");
        JLabel label6 = new JLabel("           JAVA");
        JLabel label7 = new JLabel("J         JAVA");
        JLabel label8 = new JLabel("JA       JAVA");
        JLabel label9 = new JLabel(" JAVAJAVA");
        JLabel label10 = new JLabel("  JAVAJA");

        // Add the JLabels to the JFrame
        this.getContentPane().add(label1);
        this.getContentPane().add(label2);
        this.getContentPane().add(label3);
        this.getContentPane().add(label4);
        this.getContentPane().add(label5);
        this.getContentPane().add(label6);
        this.getContentPane().add(label7);
        this.getContentPane().add(label8);
        this.getContentPane().add(label9);
        this.getContentPane().add(label10);

        JPanel panelUserName = new JPanel(new BorderLayout());
        panelUserName.setLayout(new BoxLayout(panelUserName, BoxLayout.Y_AXIS));
        panelUserName.setBackground(Color.GRAY);
        panelUserName.add(Box.createVerticalGlue()); // Add some spacing at the top
        JLabel labelUserName = new JLabel("Username:");
        labelUserName.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelUserName.add(labelUserName, BorderLayout.NORTH);
        txtUserName.setAlignmentX(Component.CENTER_ALIGNMENT);
        txtUserName.setPreferredSize(new Dimension(150, 30)); // Set the size of the text box
        panelUserName.add(txtUserName, BorderLayout.CENTER);
        panelUserName.add(Box.createVerticalGlue()); // Add some spacing at the bottom

        this.getContentPane().add(Box.createVerticalGlue()); // Add some spacing at the top
        this.getContentPane().add(panelUserName);
        this.getContentPane().add(Box.createVerticalGlue()); // Add some spacing at the bottom

        JPanel panelPassword = new JPanel(new BorderLayout());
        panelPassword.setLayout(new BoxLayout(panelPassword, BoxLayout.Y_AXIS));
        panelPassword.setBackground(Color.GRAY);
        panelPassword.add(Box.createVerticalGlue()); // Add some spacing at the top
        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPassword.add(labelPassword, BorderLayout.NORTH);
        txtPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
        txtPassword.setPreferredSize(new Dimension(150, 30)); // Set the size of the text box
        panelPassword.add(txtPassword, BorderLayout.CENTER);
        panelPassword.add(Box.createVerticalGlue()); // Add some spacing at the bottom

        this.getContentPane().add(Box.createVerticalGlue()); // Add some spacing at the top
        this.getContentPane().add(panelPassword);
        this.getContentPane().add(Box.createVerticalGlue()); // Add some spacing at the bottom

        JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelButtons.setBackground(Color.GRAY);
        btnLogin.setPreferredSize(new Dimension(400, 80));
        btnLogin.setBackground(Color.LIGHT_GRAY);
        panelButtons.add(btnLogin);

        this.getContentPane().add(Box.createVerticalGlue()); // Add some spacing at the top
        this.getContentPane().add(panelButtons);
        this.getContentPane().add(Box.createVerticalGlue()); // Add some spacing at the bottom

        // Center the login screen on the screen
        this.setLocationRelativeTo(null);
    }



}
