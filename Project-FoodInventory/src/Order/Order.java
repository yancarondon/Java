package Order;
import Food.CannedFood;
import Interface.Constants;
import Food.Food;
import Food.FreshFood;
import java.util.Scanner;

public class Order implements Constants {

    private String shippingType;
    private Food[] food;
    private String foodItemsString;


    public void getInput() {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("******Welcome******\nHow many items would you like to order? ");
        int numOfItems = scan.nextInt();

        food = new Food[numOfItems];
        foodItemsString = "";

        for (int i = 0; i < numOfItems; i++) {
            System.out.println("Enter the type of food item you are buying: Canned or Fresh");
            String foodType = scan.next();
            if (foodType.equalsIgnoreCase("canned")) {
                System.out.println("Enter the name, shelf life in years, quantity and unit price");
                food[i] = new CannedFood(scan.next(), scan.nextInt(), scan.nextInt(), scan.nextDouble());
            } else {
                System.out.println("Enter the name, shelf life in days, weight in pounds and cost per pound");
                food[i] = new FreshFood(scan.next(), scan.nextInt(), scan.nextDouble(), scan.nextDouble());
            }
            
            foodItemsString += food[i].toString() + "\n";
        }

        System.out.println("Choose Shipping Option (a) Standard Shipping (b) Express Shipping");
        shippingType = scan.next();

//        for (Food foods : food) {
//            System.out.println(foods.toString());
//        }
    }
    
    @Override
    public int calculateExpressShipping(){
        return Constants.STANDARD_SHIPPING + 7;
    }

    public double calculateTotalOrder() {

        double total = 0;

        for (Food foods : food) {
            total += foods.calculateFoodCost();
        }

        if (shippingType.equalsIgnoreCase("a")) {
            total += Constants.STANDARD_SHIPPING;
        } else {
            total += calculateExpressShipping();
        }
        return total;
    }

    @Override
    public String toString() {
        return foodItemsString + String.format("\nTotal amount of the order including shipping is $%.2f", calculateTotalOrder());
    }
}
