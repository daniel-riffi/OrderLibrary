import at.orderlibrary.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class OrderTest {

    @Before
    public void setUp() throws Exception {
        UnitTestVariables.ResetVariables();
    }

    @Test
    public void copyOrderWithNoPositions() {
        Order expected = new Order(1, 5, new ArrayList<>());
        Order actual = UnitTestVariables.order1.copyOrderWithNoPositions();
        Assert.assertEquals(actual.orderNumber, expected.orderNumber);
        Assert.assertEquals(actual.tableNumber, expected.tableNumber);
        Assert.assertEquals(actual.positions.size(), 0);
    }

    @Test
    public void copyOrderWithPositions() {
        ArrayList<Position> newPositions = new ArrayList<Position>(Arrays.asList(UnitTestVariables.position1, UnitTestVariables.position2));
        Order expected = new Order(1, 5, newPositions);
        Order actual = UnitTestVariables.order1.copyOrderWithPositions(newPositions);
        Assert.assertEquals(actual.orderNumber, expected.orderNumber);
        Assert.assertEquals(actual.tableNumber, expected.tableNumber);
        Assert.assertEquals(UnitTestVariables.order1.positions, new ArrayList<Position>(Arrays.asList(UnitTestVariables.position3)));
        Assert.assertEquals(actual.positions, newPositions);
    }

    @Test
    public void copyOrderWithFunction() {
        Order expected = new Order(1, 5, new ArrayList<Position>(Arrays.asList(UnitTestVariables.position1, UnitTestVariables.position2)));
        Order actual = UnitTestVariables.order1.copyOrderWithFunction(x -> x.product.offer.price > 5);
        Assert.assertEquals(actual.orderNumber, expected.orderNumber);
        Assert.assertEquals(actual.tableNumber, expected.tableNumber);
        Assert.assertEquals(UnitTestVariables.order1.positions, new ArrayList<Position>(Arrays.asList(UnitTestVariables.position2)));
        Assert.assertEquals(actual.positions, new ArrayList<Position>(Arrays.asList(UnitTestVariables.position1, UnitTestVariables.position3)));
    }

    @Test
    public void testEquals_1() {
        Order orderForComparison = new Order(1, 5, UnitTestVariables.positions);
        Assert.assertTrue(UnitTestVariables.order1.equals(orderForComparison));
    }

    @Test
    public void testEquals_2() {
        Order orderForComparison = new Order(5, 5, UnitTestVariables.positions);
        Assert.assertFalse(UnitTestVariables.order1.equals(orderForComparison));
    }
}