import java.io.Serializable;

public class Product implements Serializable {
    public Offer offer;
    public String specialWish;

    public Product(Offer offer, String specialWish){
        this.offer = offer;
        this.specialWish = specialWish;
    }

    public Product(Offer offer){
        this.offer = offer;
        this.specialWish = "";
    }

    public Product(){}

    @Override
    public String toString() {
        return offer.toString() + ", specialWish: " + specialWish;
    }
}
