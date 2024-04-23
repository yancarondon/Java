
package Food;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FreshFood extends Food{
    
    private double costPerPound;
    private double weight;
    private final int shelfLife;
    
    public FreshFood(String name, int shelfLife, double weight, double costPerPound)
    {
        super(name);
        this.shelfLife = shelfLife;
        this.weight = weight;
        this.costPerPound = costPerPound;
        
    }
    
    public void setWeight(double w)
    {
        weight = w;
    }
    
    public void setCostPerPound(double c)
    {
        costPerPound = c;
    }
    
    @Override
    public double calculateFoodCost(){
        return weight * costPerPound;
    }
    
    @Override
    public String calculateExpiryDate(){
        
        LocalDate currentDate = LocalDate.now();
        LocalDate expiryDate = currentDate.plusDays(shelfLife);
        
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String expiryDateFormatted = expiryDate.format(format);
       
        return expiryDateFormatted;
        
    }
    
    @Override
    public String toString(){
        return super.toString() + "\nShelf Life is " + shelfLife + " days"
                + "\n---------------------------------";
    }
}
