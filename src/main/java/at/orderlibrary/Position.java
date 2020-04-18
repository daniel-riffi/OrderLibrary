package at.orderlibrary;

public class Position {
    public Product product;
    public int amount;
    private Order order;

    public Position(Product product, int amount, Order order){
        this.product = product;
        this.amount = amount;
        this.order = order;
    }

    public Position(Product product, int amount){
        this.product = product;
        this.amount = amount;
    }

    public Position(){}

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return product.toString() + ", amount: " + amount;
    }

    @Override
    public boolean equals(Object other){
        Position pos = (Position) other;
        return product.offer.id == pos.product.offer.id;
    }
    public double calcPrice(){
        return product.offer.price * amount;
    }
    public Position(Position another){
        this.product = another.product;
        this.amount = another.amount;
    }
}
