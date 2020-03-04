package at.orderlibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Order  {
    public List<Position> positions;
    public int tableNumber;
    public int orderNumber;

    public Order(int orderNumber, int tableNumber, ArrayList<Position> positions){
        this.orderNumber = orderNumber;
        this.tableNumber = tableNumber;
        this.positions = positions;
    }

    public Order(int orderNumber, int tableNumber){
        this.orderNumber = orderNumber;
        this.tableNumber = tableNumber;
        this.positions = new ArrayList<Position>();
    }

    public Order(){}

    public Order copyOrderWithNoPositions(){
        return new Order(orderNumber, tableNumber);
    }

    public Order copyOrderWithPositions(ArrayList<Position> newPositions){
        newPositions.forEach(x -> positions.remove(x));
        return new Order(orderNumber, tableNumber, newPositions);
    }

    public Order copyOrderWithFunction(Predicate<Position> predicate){
        ArrayList<Position> newPositions = new ArrayList<>(positions.stream().filter(predicate).collect(Collectors.toList()));
        newPositions.forEach(x -> positions.remove(x));
        return new Order(orderNumber, tableNumber, newPositions);
    }

    @Override
    public String toString() {
        return "orderNumber: " + orderNumber + ", tableNumber: " + tableNumber + ", positions: " + positions.size();
    }

    @Override
    public boolean equals(Object other){
        Order order = (Order)other;
        return orderNumber == order.orderNumber;
    }
}
