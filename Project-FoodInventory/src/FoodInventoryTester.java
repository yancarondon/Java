import Order.Order;

public class FoodInventoryTester {

    public FoodInventoryTester() {

        Order order = new Order();
        order.getInput();
        System.out.println(order);
        
    }

    public static void main(String[] args) {
        new FoodInventoryTester();
    }

}
