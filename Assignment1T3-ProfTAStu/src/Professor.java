
public class Professor extends People {
    
    protected int labHours;
    
    public Professor(String fname, String lname){
    
        super("Professor", fname, lname);
        
    }
    
    @Override
    public int getParticipatingHours(int courseHours){
    
        if(courseHours > 4){
        labHours = 2;
        }else{
        labHours = 1;
        }
        
        return courseHours - labHours; 
       
    }
    
     public String display(int courseHours){
    
        return getTitle() + " " + getFirstName() + " " + getLastName() + " " + getParticipatingHours(courseHours);
        
    }

   
    
}
