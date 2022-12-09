public class Order {
    private String CustomerName, Food, Beverage;
    private int OrderNumber;

    public Order(int OrderN, String CustomerN, String Fo, String Be){
        OrderNumber = OrderN;
        CustomerName = CustomerN;
        Food = Fo;
        Beverage = Be;
    }

    public Order(){
        
    }

    public void setOrder(int OrderN, String CustomerN, String Fo, String Be){
        OrderNumber = OrderN;
        CustomerName = CustomerN;
        Food = Fo;
        Beverage = Be;
    }

    public Order getOrder(){
        return this;
    }
    // public double getTotalScore(){
    //     return midScore+ finalScore+ quizScore+ prjScore+ collabScore;
    // }
    public String getCustomerName(){
        return CustomerName;
    }
    public int getOrderNumber(){
        return OrderNumber;
    }
    public String getFood(){
        return Food;
    }
    public String getBeverage(){
        return Beverage;
    }
}
