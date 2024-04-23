
public class ProfTAStuTester {

    public static void main(String[] args) {

        String output, finalDisplay = "";

        String s = """
                   Professor Isaac Newton Physics 6 
                   TA Marie Curie Physics 6 
                   Professor Isaac Newton Calculus 4 
                   Student Amy Adams Calculus 4 
                   Student Will Smith Calculus 4 
                   Student Brad Pitt Physics 6 
                   Student Will Smith Physics 6 
                   Professor Dmitri Mendeleev Chemistry 6 
                   TA Carl Gauss Calculus 4 
                   Student Amy Adams Economics 3 
                   Professor Adam Smith Economics 3 
                   TA Marie Curie Chemistry 6 
                   Student Brad Pitt Chemistry 6 
                   Student Will Smith Chemistry 6 
                   end 
                   """;

        String[] lines = s.split("\n");

        People[] people = new People[lines.length];
        int index = 0;

        for (int i = 0; i < lines.length; i++) {

            String[] parts = lines[i].split("\\s+");

            if (parts[0].equalsIgnoreCase("end")) {
                break;
            }

            String title = parts[0];
            String fname = parts[1];
            String lname = parts[2];
            //String subject = parts[3];
            int courseHours = Integer.parseInt(parts[4]);

            boolean personExists = false;
            
            for(int j = 0; j < index; j++){
            
                if(people[j] != null && people[j].fname.equals(fname) && people[j].lname.equals(lname)){
                    people[j].accumulateHours(courseHours);
                    personExists = true;
                    break;
                }
            
            }
            
            if(!personExists){
            if (title.equalsIgnoreCase("Professor")) {
                people[index] = new Professor(fname,lname);
              
            } else if (title.equalsIgnoreCase("TA")) {
                people[index] = new TA(fname,lname);

            } else {
                people[index] = new Student(fname,lname);
            }
            index++;
            }
            
            
        }
        
        for(int i = 0; i <index; i++){
            finalDisplay += people[i].getTitle() + " " +
                            people[i].fname + " " +
                            people[i].lname + " " +
                            people[i].getTotalHours() + "\n";
        }

        System.out.println(finalDisplay);
    }

}
