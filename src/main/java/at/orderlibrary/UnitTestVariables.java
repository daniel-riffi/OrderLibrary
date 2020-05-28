package at.orderlibrary;

import java.util.ArrayList;
import java.util.Arrays;

public class UnitTestVariables {

    public static Offer offer1;
    public static Offer offer2;
    public static Offer offer3;
    public static Offer offer4;
    public static Offer offer5;

    public static Product product1;
    public static Product product2;
    public static Product product3;
    public static Product product4;
    public static Product product5;

    public static Position position1;
    public static Position position2;
    public static Position position3;
    public static Position position4;
    public static Position position5;

    public static ArrayList<Position> positions1;
    public static ArrayList<Position> positions2;
    public static ArrayList<Position> positions3;

    public static Order order1;
    public static Order order2;
    public static Order order3;

    public static void ResetVariables(){
        offer1 = new Offer(1, "Schnitzel", 9.99, Category.FOOD);
        offer2 = new Offer(2, "Bier", 4.5, Category.ALCOHOLIC_DRINK);
        offer3 = new Offer(3, "Hendl", 11.5, Category.ALCOHOLIC_DRINK);
        offer4 = new Offer(4, "Kuchen", 8.5, Category.DESERT);
        offer5 = new Offer(5, "Most", 3.5, Category.ALCOHOLIC_DRINK);

        product1 = new Product(offer1);
        product2 = new Product(offer2, "extra kalt");
        product3 = new Product(offer3, "frisch");
        product4 = new Product(offer4);
        product5 = new Product(offer5);

        position1 = new Position(product1, 3);
        position2 = new Position(product2, 10);
        position3 = new Position(product3, 2);
        position4 = new Position(product4, 5);
        position5 = new Position(product5, 3);

        positions1 = new ArrayList(Arrays.asList(position1, position2, position3));
        positions2 = new ArrayList(Arrays.asList(position4));
        positions3 = new ArrayList(Arrays.asList(position5));

        order1 = new Order(1, "5", positions1);
        order2 = new Order(2, "6", positions2);
        order3 = new Order(3, "7", positions3);

        positions1.forEach(x -> x.setOrder(order1));
        positions2.forEach(x -> x.setOrder(order2));
        positions3.forEach(x -> x.setOrder(order3));
    }
}
