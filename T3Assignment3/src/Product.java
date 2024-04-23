class Product {
    private int id;
    private String name;
    private int count;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
        this.count = 0;
    }

    public void incrementCount() {
        count++;
    }

    @Override
    public String toString() {
        return id + " " + name + ": " + count + " items";
    }
}