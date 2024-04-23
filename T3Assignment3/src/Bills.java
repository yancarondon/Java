import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bills {

    Map<Integer, Customer> customers = new HashMap<>();
    Map<Integer, Product> products = new HashMap<>();

   public void processSalesFile(String filename) {
    try (Scanner scanner = new Scanner(new File(filename))) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!line.trim().isEmpty()) {
                String[] parts = line.split(" ");
                int customerId = Integer.parseInt(parts[0]);
                String firstName = parts[1];
                String lastName = parts[2];
                int productId = Integer.parseInt(parts[3]);
                String productName = parts[4];
                double singleItemPrice = Double.parseDouble(parts[5]);
                int quantity = Integer.parseInt(parts[6]);

                if (!customers.containsKey(customerId)) {
                    customers.put(customerId, new Customer(customerId, firstName, lastName));
                }

                if (!products.containsKey(productId)) {
                    products.put(productId, new Product(productId, productName));
                }

                customers.get(customerId).updateBill(singleItemPrice * quantity);
                for (int i = 0; i < quantity; i++) {
                    products.get(productId).incrementCount();
                }
            }
        }
    } catch (FileNotFoundException e) {
        System.err.println("File not found: " + filename);
    }
}



    public void printFinalBills() {
        System.out.println("Final Bills:");
        for (Customer customer : customers.values()) {
            System.out.println(customer);
        }
    }

    public void printProductCounts() {
        System.out.println("Product Counts:");
        for (Product product : products.values()) {
            System.out.println(product);
        }
    }
}