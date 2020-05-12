package at.orderlibrary;

public class Offer {
    public int id;
    public Category category;
    public String name;
    public double price;

    public Offer(int id, String name, double price, Category category){
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Offer(){ }

    @Override
    public String toString() {
        return "id: " + id + "name: " + name + ", price: " + price + ", category: " + category.name();
    }
}
