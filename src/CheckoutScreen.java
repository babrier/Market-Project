import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CheckoutScreen extends JFrame {

    private JButton btnAdd = new JButton("Add a new item");
    private JButton btnPay = new JButton("Finish and Pay");

    private DefaultTableModel items = new DefaultTableModel(); // store information for the table!

    private JTable tblItems = new JTable(items); // null, new String[]{"ProductID", "Product Name", "Price", "Quantity", "Cost"});
    private JLabel labTotal = new JLabel("Subtotal: ");
    private JLabel labTax = new JLabel("TAX: 15%");
    private JLabel labTotalWT = new JLabel("Total With Tax: ");

    public CheckoutScreen() {
        this.setTitle("Seller View");
        this.setLayout(new BorderLayout());
        this.setSize(600, 600);
        this.getContentPane().setBackground(Color.DARK_GRAY); // set the background color to gray

        // Create table
        items.addColumn("Product ID");
        items.addColumn("Name");
        items.addColumn("Price");
        items.addColumn("Quantity");
        items.addColumn("Cost");

        // Create panel for table
        JPanel panelOrder = new JPanel(new GridLayout(5, 1));
        tblItems.setBounds(0, 0, 600, 10);
        panelOrder.setBackground(Color.LIGHT_GRAY);

        // Set font size for table header and labels
        Font currentFont = tblItems.getTableHeader().getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.5f);
        tblItems.getTableHeader().setFont(newFont);
        labTotal.setFont(newFont);
        labTax.setFont(newFont);
        labTotalWT.setFont(newFont);

        panelOrder.add(tblItems.getTableHeader());
        panelOrder.add(tblItems);
        panelOrder.add(labTotal);
        panelOrder.add(labTax);
        panelOrder.add(labTotalWT);
        tblItems.setFillsViewportHeight(true);
        this.add(panelOrder, BorderLayout.CENTER);

        // Create panel for buttons
        JPanel panelButton = new JPanel();
        panelButton.setBackground(Color.DARK_GRAY); // set the background color to gray
        panelButton.setLayout(new GridLayout(1, 2, 1, 0)); // use a grid layout with horizontal spacing between the buttons
        btnAdd.setBackground(Color.GRAY); // set the button background color to gray
        btnAdd.setPreferredSize(new Dimension(btnAdd.getPreferredSize().width, btnAdd.getPreferredSize().height * 3)); // set the preferred size of the Add button
        panelButton.add(btnAdd);
        btnPay.setBackground(Color.GRAY); // set the button background color to gray
        btnPay.setPreferredSize(new Dimension(btnPay.getPreferredSize().width, btnPay.getPreferredSize().height * 3)); // set the preferred size of the Pay button
        panelButton.add(btnPay);

        // Add panels to the checkout screen
        this.add(panelOrder, BorderLayout.CENTER);
        this.add(panelButton, BorderLayout.SOUTH);

        // Center the window on the screen
        setLocationRelativeTo(null);
    }






    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnPay() {
        return btnPay;
    }

    public JLabel getLabTotal() {
        return labTotal;
    }
    public JLabel getLabTotalWithTax() {
        return labTotalWT;
    }


    public void addRow(Object[] row) {
        items.addRow(row);              // add a row to list of item!
        //    items.fireTableDataChanged();
    }
}
