package at.orderlibrary;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Order implements Serializable {
    public List<Position> positions;
    public String tableNumber;
    public int orderNumber;

    public Order(int orderNumber, String tableNumber, ArrayList<Position> positions){
        this.orderNumber = orderNumber;
        this.tableNumber = tableNumber;
        this.positions = positions;
    }

    public Order(int orderNumber, String tableNumber, Position position){
        this.orderNumber = orderNumber;
        this.tableNumber = tableNumber;
        this.positions = new ArrayList<>(Arrays.asList(position));
    }

    public Order(int orderNumber, String tableNumber){
        this.orderNumber = orderNumber;
        this.tableNumber = tableNumber;
        this.positions = new ArrayList<Position>();
    }

    public Order(){}

    public Order copyOrderWithNoPositions(){
        return new Order(orderNumber, tableNumber);
    }

    public Order copyOrderWithPositions(Position position){
        if(position.amount == 0){
            positions.remove(position);
        }
        Order newOrder = new Order(orderNumber, tableNumber, position);
        position.setOrder(newOrder);
        return newOrder;
    }

    public Order copyOrderWithFunction(Predicate<Position> predicate){
        ArrayList<Position> newPositions = new ArrayList<>(positions.stream().filter(predicate).collect(Collectors.toList()));
        newPositions.forEach(x -> positions.remove(x));
        return new Order(orderNumber, tableNumber, newPositions);
    }

    public void addPosition(Position position) {
        this.positions.add(position);
        Order oldOrder = position.getOrder();
        //oldOrder.positions.stream().filter(x -> x.equals(position)).findFirst().get().amount--;
        position.setOrder(this);
    }

    public void reinitPositionsWithOrder(){
        positions.forEach(x -> x.setOrder(this));
    }

    @Override
    public String toString() {
        return "Bestellung " + orderNumber;
    }

    @Override
    public boolean equals(Object other){
        Order order = (Order)other;
        return orderNumber == order.orderNumber;
    }
}
