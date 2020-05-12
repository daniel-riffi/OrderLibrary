package at.orderlibrary;

import java.io.Serializable;

public class Position implements Serializable {
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

    public Position copyPositionAndDecreaseAmount(){
        this.amount--;
        if(amount == 0) order.positions.remove(this);
        return new Position(this.product, 1, this.order);
    }

    @Override
    public String toString() {

        return amount + "x " + product.offer.name;
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
