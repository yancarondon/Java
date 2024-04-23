
public class T3Assignment3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Bills bills = new Bills();
        bills.processSalesFile("Sales.txt");
        bills.printFinalBills();
        bills.printProductCounts();
        
    }
    
}
