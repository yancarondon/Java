
package Food;

public abstract class Food{
    
    private final String name;
   
    protected Food(String name)
    {
        this.name = name;
    }
    
    public abstract double calculateFoodCost();
     
    protected abstract String calculateExpiryDate();
    
    @Override
    public String toString(){
        return this.getClass().getSimpleName() + " " + name + " costs $" + String.format("%.2f",calculateFoodCost()) +
                "\nIt is good until " + calculateExpiryDate();
    }
    
    
}
