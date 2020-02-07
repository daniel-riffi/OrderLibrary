import at.orderlibrary.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class OrderTest {

    private Order order;
    private ArrayList<Position> positions;
    private Position position1;
    private Position position2;
    private Position position3;

    @Before
    public void setUp() throws Exception {

        Offer offer1 = new Offer(1, "Schnitzel", 9.99, Category.FOOD);
        Offer offer2 = new Offer(2, "Bier", 4.5, Category.ALCOHOLIC_DRINK);
        Offer offer3 = new Offer(3, "Hendl", 11.5, Category.FOOD);

        Product product1 = new Product(offer1);
        Product product2 = new Product(offer2, "extra kalt");
        Product product3 = new Product(offer3, "gut durch");

        position1 = new Position(product1, 3);
        position2 = new Position(product2, 10);
        position3 = new Position(product3, 2);

        positions = new ArrayList<>(Arrays.asList(position1, position2, position3));
        order = new Order(1, 5, positions);
        positions.forEach(x -> x.order = order);
    }

    @Test
    public void copyOrderWithNoPositions() {
        Order expected = new Order(1, 5, new ArrayList<>());
        Order actual = order.copyOrderWithNoPositions();
        Assert.assertEquals(actual.orderNumber, expected.orderNumber);
        Assert.assertEquals(actual.tableNumber, expected.tableNumber);
        Assert.assertEquals(actual.positions.size(), 0);
    }

    @Test
    public void copyOrderWithPositions() {
        ArrayList<Position> newPositions = new ArrayList<Position>(Arrays.asList(position1, position2));
        Order expected = new Order(1, 5, newPositions);
        Order actual = order.copyOrderWithPositions(newPositions);
        Assert.assertEquals(actual.orderNumber, expected.orderNumber);
        Assert.assertEquals(actual.tableNumber, expected.tableNumber);
        Assert.assertEquals(order.positions, new ArrayList<Position>(Arrays.asList(position3)));
        Assert.assertEquals(actual.positions, newPositions);
    }

    @Test
    public void copyOrderWithFunction() {
        Order expected = new Order(1, 5, new ArrayList<Position>(Arrays.asList(position1, position3)));
        Order actual = order.copyOrderWithFunction(x -> x.product.offer.price > 5);
        Assert.assertEquals(actual.orderNumber, expected.orderNumber);
        Assert.assertEquals(actual.tableNumber, expected.tableNumber);
        Assert.assertEquals(order.positions, new ArrayList<Position>(Arrays.asList(position2)));
        Assert.assertEquals(actual.positions, new ArrayList<Position>(Arrays.asList(position1, position3)));
    }

    @Test
    public void testEquals_1() {
        Order orderForComparison = new Order(1, 5, positions);
        Assert.assertTrue(order.equals(orderForComparison));
    }

    @Test
    public void testEquals_2() {
        Order orderForComparison = new Order(5, 5, positions);
        Assert.assertFalse(order.equals(orderForComparison));
    }
}