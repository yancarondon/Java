
import java.util.Scanner;


public class PropertyTaxTester {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        PropertyTax property = new PropertyTax();
        
        System.out.println("Enter the actual value of the property: ");
        
        property.setActualValue(scan.nextDouble());
        
        System.out.println("Enter the type of property. Type 'R' for Residential, 'L' for Farmland and 'C' for Commercial: ");
    
        property.setPropertyType(scan.next().charAt(0));
        
        System.out.println(property);
    }
    
}
