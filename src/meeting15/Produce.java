package meeting15;

public class Produce extends Item{
    private String country;

    public Produce(String country, double price, String name) {
        super(name, price);
        this.country = country;
    }

}
