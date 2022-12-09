import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class index extends JFrame{
    public static int OrderN = 0;
    public JPanel IndexPanel;
    public JButton orderButton;
    public JButton servedButton;
    public JButton currentorderButton;
    public JButton numberOfOrdersButton;
    public JButton searchOrderButton;
    public JButton clearOrderButton;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JPanel midPanel;
    private JPanel in_topPanel;
    private JPanel in_midPanel;
    private JPanel button_midPanel;
    private JPanel button_leftPanel;
    private JPanel button_rightPanel;
    private JLabel Cooker_image;

    Order order;
    QueueTest test = new QueueTest();
    Object obj;

    ArrayListQueue queue = new ArrayListQueue();

    public index() {
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    order = getElement();
                    obj = order;
                    queue.enqueue(obj);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        servedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    obj = queue.dequeue();
                    order = (Order) obj;
                    test.printElement(order);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }
        });
        currentorderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    obj = queue.front();
                    order = (Order) obj;
                    test.printElement(order);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        numberOfOrdersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(null, "Waiting Order: "+queue.length());

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        searchOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               try {

                   int key;
                   key = Integer.parseInt(JOptionPane.showInputDialog(null, "Order Number : "));

                   obj = queue.SearchByOrderNumber(key);
                   order = (Order) obj;
                   test.printElement(order);
               } catch (Exception ex) {
                   JOptionPane.showMessageDialog(null, ex.getMessage());
               }               
            }
        });
        clearOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    queue.clear();
                    OrderN = 0;
                    JOptionPane.showMessageDialog(null, "Reset Order complete.");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {

        showIndexWindow();

    }

    public static void showIndexWindow() {
        index i = new index();
        i.setContentPane(i.IndexPanel);
        i.setTitle("Main Menu");
//        i.setBounds(600, 200, 200, 200);
        i.setSize(702,702);
        i.pack();
        i.setLocationRelativeTo(null);
        i.setVisible(true);
        i.setResizable(false);
        i.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        i.orderButton.setOpaque(false);
        i.orderButton.setContentAreaFilled(false);
        i.orderButton.setBorderPainted(false);

        i.servedButton.setOpaque(false);
        i.servedButton.setContentAreaFilled(false);
        i.servedButton.setBorderPainted(false);

        i.currentorderButton.setOpaque(false);
        i.currentorderButton.setContentAreaFilled(false);
        i.currentorderButton.setBorderPainted(false);

        i.numberOfOrdersButton.setOpaque(false);
        i.numberOfOrdersButton.setContentAreaFilled(false);
        i.numberOfOrdersButton.setBorderPainted(false);

        i.searchOrderButton.setOpaque(false);
        i.searchOrderButton.setContentAreaFilled(false);
        i.searchOrderButton.setBorderPainted(false);

        i.clearOrderButton.setOpaque(false);
        i.clearOrderButton.setContentAreaFilled(false);
        i.clearOrderButton.setBorderPainted(false);

    }

    public static Order getElement() {
        Order temp;

        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();
        JTextField field3 = new JTextField();
        String CustomerN = "", Fo = "", Be = "";

        int ON = runOrder();

        // JOptionPane.showMessageDialog(null, "Order Number : "+ON);
        Object[] message = {
                "Customer Name", field1,
                "Food",field2,
                "Beverage",field3,
        };
        int result = JOptionPane.showConfirmDialog(null, message, "Order No."+ON, JOptionPane.OK_CANCEL_OPTION);
        if(result == JOptionPane.OK_OPTION){
            CustomerN = field1.getText();
            Fo = field2.getText();
            Be = field3.getText();
            temp = new Order(ON, CustomerN, Fo, Be);
            temp.setOrder(ON, CustomerN, Fo, Be);
            return temp;
        }
        else {
            OrderN--;
            return null;
        }
    }

    public void printElement(Order order) {
        if (order != null) {
            JOptionPane.showMessageDialog(null,
                    "Order Number \t: " + order.getOrderNumber() +
                            "\nCustomer Name \t: " + order.getCustomerName() +
                            "\nFood \t: " + order.getFood() +
                            "\nBeverage\t: " + order.getBeverage());
        }
    }
    public static int runOrder(){
        OrderN++;
        return OrderN;
    }

}
