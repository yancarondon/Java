public class Student extends People {
    
//    protected int courseHours;
    
     public Student(String fname, String lname){
    
        super("Student", fname, lname);
        
    }
    
    @Override
    public int getParticipatingHours(int courseHours){

        return courseHours; 
       
    }
    
     public String display(int courseHours){
    
        return getTitle() + " " + getFirstName() + " " + getLastName() + " " + getParticipatingHours(courseHours);
        
    }
    
}
