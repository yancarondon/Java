
package Food;
import Interface.Constants;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CannedFood extends Food{
   
    
    private double unitPrice;
    private int quantity;
    private final int shelfLife;
    
    public CannedFood(String name, int shelfLife, int quantity, double unitPrice)
    {
        super(name);
        this.shelfLife = shelfLife;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        
    }
    
    public void setWeight(int q)
    {
        quantity = q;
    }
    
    public void setCostPerPound(double u)
    {
        unitPrice = u;
    }
    
  
    public double calculateFoodCost(){
        return quantity * unitPrice * (1 + Constants.CANNED_FOOD_TAX);
    }
    
    @Override
    public String calculateExpiryDate(){
        
        LocalDate currentDate = LocalDate.now();
        LocalDate expiryDate = currentDate.plusYears(shelfLife);
        
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String expiryDateFormatted = expiryDate.format(format);
       
        return expiryDateFormatted;
        
    }
     
     
    
    @Override
    public String toString(){
        return super.toString() + "\nShelf Life is " + shelfLife + " years"
                + "\n---------------------------------";
    }
}
