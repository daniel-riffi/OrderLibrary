package at.orderlibrary;

import java.io.Serializable;

public class Position implements Serializable {
    public Product product;
    public int amount;
    public Order order;

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

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
        return product.offer.id == pos.product.offer.id && amount == pos.amount;
    }
}
