
abstract class People implements ParticipateHours {
    
    protected String title, fname, lname;
    protected int totalHours;
    
    public People(String title, String fname, String lname){
    
        this.title = title;
        this.fname = fname;
        this.lname = lname;
        this.totalHours = 0;
        
    }
    
    
    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return fname;
    }

    public String getLastName() {
        return lname;
    }
    
    public int getTotalHours(){
        return totalHours;
    }
    
    public void accumulateHours(int hours){
        this.totalHours += hours;
    }
    
    
    @Override
    public abstract int getParticipatingHours(int courseHours);
    
//    public abstract String display(int courseHours);
    
}
