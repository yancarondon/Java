class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private double totalBill;

    public Customer(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalBill = 0.0;
    }

    public void updateBill(double amount) {
        totalBill += amount;
    }

    @Override
    public String toString() {
        return id + " " + firstName + " " + lastName + ": $" + totalBill;
    }
}