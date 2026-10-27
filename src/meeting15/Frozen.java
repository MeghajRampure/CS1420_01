package meeting15;

public class Frozen {
    private String name;
    private int price;
    private String expiration;

    public String receiptString(){
        return this.name + " : $" + this.price + " : " + this.expiration;
    }
}
