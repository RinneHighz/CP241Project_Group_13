import javax.swing.*;

public class QueueTest {
    public static int OrderN = 0;
    public static void main(String[] args) throws Exception {
        String choice;
        int ch = 999;
        Order order;        
        QueueTest test = new QueueTest();
        Object obj;

        //  ArrayQueue queue = new ArrayQueue();
        // CircularArrayQueue queue = new CircularArrayQueue();
        ArrayListQueue queue = new ArrayListQueue();
        // LinkedQueue queue= new LinkedQueue();
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
        }
        temp = new Order(ON, CustomerN, Fo, Be);
        temp.setOrder(ON, CustomerN, Fo, Be);
        return temp;
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
