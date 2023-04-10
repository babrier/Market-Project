import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CheckoutController implements ActionListener {
    private LoginScreen loginScreen;
    private CheckoutScreen view;
    private DataAdapter dataAdapter;
    private DataAccess myDAO;
    User user;

    private Order order;

    int orderID = 1;
    Date date;


    public CheckoutController(CheckoutScreen view, DataAdapter dataAdapter, DataAccess dao) {
        this.dataAdapter = dataAdapter;
        this.view = view;
        myDAO = dao;

        view.getBtnAdd().addActionListener(this);
        view.getBtnPay().addActionListener(this);

        order = new Order();

    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getBtnAdd()) {
            addProduct();
        } else if (e.getSource() == view.getBtnPay()) {
            saveOrder();
            commitOrder();
            orderID++;
        }
    }




private void saveOrder() {
    OrderModel orderModel = new OrderModel();
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
    String dateString = dateFormat.format(calendar.getTime());
    double totalCost = order.getTotalCost();
    double totalTax = .15;

    try {

        orderModel.OrderID = orderID;

        orderModel.OrderDate = dateString;
        orderModel.Customer = "Adam Smith";
        orderModel.TotalCost = totalCost;
        orderModel.TotalTax = totalTax;

        myDAO.saveOrder(orderModel);
        JOptionPane.showMessageDialog(null, "Order saved successfully!");


    }
    catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Invalid format for numbers!");
        ex.printStackTrace();
    }
}
    private void commitOrder() {

        double totalCost = order.getTotalCost();
        double totalTax = .15;
        double costwithtax = order.getTotalCost() + (.15 * order.getTotalCost());
        order = new Order();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        String dateString = dateFormat.format(calendar.getTime());

        order.setOrderID(orderID);
        order.setDate(dateString);
        order.getCustomerName();
        order.setCustomerName("adam");
        order.setTotalCost(costwithtax);
        costwithtax = totalCost;
        order.setTotalTax(totalTax);
        dataAdapter.saveOrder(order);

        return;
    }



    private void addProduct() {
        String id = JOptionPane.showInputDialog("Enter ProductID: ");
        Product product = dataAdapter.loadProduct(Integer.parseInt(id));
        if (product == null) {
            JOptionPane.showMessageDialog(null, "This product does not exist!");
            return;
        }

        double quantity = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter quantity: "));

        if (quantity < 0 || quantity > product.getQuantity()) {
            JOptionPane.showMessageDialog(null, "This quantity is not valid!");
            return;
        }

        OrderLine line = new OrderLine();
        line.setOrderID(this.order.getOrderID());
        line.setProductID(product.getProductID());
        line.setQuantity(quantity);
        line.setCost(quantity * product.getPrice());

        product.setQuantity(product.getQuantity() - quantity); // update new quantity!!
        dataAdapter.saveProduct(product); // and store this product back right away!!!

        order.getLines().add(line);
        order.setTotalCost(order.getTotalCost() + line.getCost());

        Object[] row = new Object[5];
        row[0] = line.getProductID();
        row[1] = product.getName();
        row[2] = product.getPrice();
        row[3] = line.getQuantity();
        row[4] = line.getCost();

        this.view.addRow(row);
        this.view.getLabTotal().setText("Total: $" + order.getTotalCost());
        this.view.getLabTotalWithTax().setText("Total With Tax: $" + (order.getTotalCost() + (.15 * order.getTotalCost())));
        this.view.invalidate();
    }

}