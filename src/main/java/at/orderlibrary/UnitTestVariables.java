package at.orderlibrary;

import java.util.ArrayList;
import java.util.Arrays;

public class UnitTestVariables {

    public static Offer offer1;
    public static Offer offer2;
    public static Offer offer3;

    public static Product product1;
    public static Product product2;
    public static Product product3;

    public static Position position1;
    public static Position position2;
    public static Position position3;

    public static ArrayList<Position> positions;
    public static Order order1;

    public static void ResetVariables(){
        offer1 = new Offer(1, "Schnitzel", 9.99, Category.FOOD);
        offer2 = new Offer(2, "Bier", 4.5, Category.ALCOHOLIC_DRINK);
        offer3 = new Offer(2, "Hendl", 11.5, Category.ALCOHOLIC_DRINK);

        product1 = new Product(offer1);
        product2 = new Product(offer2, "extra kalt");
        product3 = new Product(offer3, "frisch");

        position1 = new Position(product1, 3);
        position2 = new Position(product2, 10);
        position3 = new Position(product3, 2);

        positions = new ArrayList(Arrays.asList(position1, position2, position3));

        order1 = new Order(1, 5, positions);

        positions.forEach(x -> x.setOrder(order1));
    }
}
