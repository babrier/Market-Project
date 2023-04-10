import javax.swing.*;
import java.awt.*;

public class ProductView extends JFrame {

    public JTextField txtProductID = new JTextField(30);
    public JTextField txtProductName = new JTextField(30);
    public JTextField txtProductPrice = new JTextField(30);
    public JTextField txtProductQuantity = new JTextField(30);

    public JButton btnLoad = new JButton("Load");
    public JButton btnSave = new JButton("Save");

    public ProductView() {

        this.setTitle("Product View");
        this.setSize(new Dimension(600, 400));
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));

        JPanel line1 = new JPanel();
        line1.add(new JLabel("Product ID"));
        txtProductID.setPreferredSize(new Dimension(200, 40)); // Set the preferred size for txtProductID
        line1.add(txtProductID);
        this.getContentPane().add(line1);
        this.getContentPane().setBackground(Color.GRAY);

        JPanel line2 = new JPanel();
        line2.add(new JLabel("Product Name"));
        txtProductName.setPreferredSize(new Dimension(200, 40)); // Set the preferred size for txtProductName
        line2.add(txtProductName);
        this.getContentPane().add(line2);
        this.getContentPane().setBackground(Color.GRAY);

        JPanel line3 = new JPanel();
        line3.add(new JLabel("Price"));
        txtProductPrice.setPreferredSize(new Dimension(200, 40)); // Set the preferred size for txtProductPrice
        line3.add(txtProductPrice);
        this.getContentPane().add(line3);
        this.getContentPane().setBackground(Color.GRAY);

        JPanel line4 = new JPanel();
        line4.add(new JLabel("Quantity"));
        txtProductQuantity.setPreferredSize(new Dimension(200, 40)); // Set the preferred size for txtProductQuantity
        line4.add(txtProductQuantity);
        this.getContentPane().add(line4);
        this.getContentPane().setBackground(Color.GRAY);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2));  // Use a GridLayout with 1 row and variable number of columns
        buttonPanel.setBackground(Color.GRAY);  // Set the background color of the panel to gray

        btnLoad.setBackground(Color.GRAY);  // Set the background color of the buttons to gray
        btnSave.setBackground(Color.GRAY);

        buttonPanel.add(btnLoad);
        buttonPanel.add(btnSave);

        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Center the window on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) (screenSize.getWidth() / 2);
        int centerY = (int) (screenSize.getHeight() / 2);
        this.setLocation(centerX - (this.getWidth() / 2), centerY - (this.getHeight() / 2));
    }


}




