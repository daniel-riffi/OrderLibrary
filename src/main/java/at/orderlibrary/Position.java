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
        if(product.specialWish.equals("")) return amount + "x " + product.offer.name;
        else return amount + "x " + product.offer.name + " (" + product.specialWish + ")";
    }

    @Override
    public boolean equals(Object other){
        Position pos = (Position) other;
        return product.offer.id == pos.product.offer.id && product.specialWish.equals(product.specialWish);
    }
    public double calcPrice(){
        return product.offer.price * amount;
    }
    public Position(Position another){
        this.product = another.product;
        this.amount = another.amount;
    }
}
