
public class TA extends People {
    
    protected int labHours;
    
    
     public TA(String fname, String lname){
    
        super("TA", fname, lname);
        
    }
    
    @Override
    public int getParticipatingHours(int courseHours){
    
        if(courseHours > 4){
        labHours = 2;
        }else{
        labHours = 1;
        }
        
        return labHours; 
       
    }
    
     public String display(int courseHours){
    
        return getTitle() + " " + getFirstName() + " " + getLastName() + " " + getParticipatingHours(courseHours);
        
    }
}
