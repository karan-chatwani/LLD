package models;

public class FiveKmFare extends BaseFare {
    private int price;

    public FiveKmFare(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price + super.getPrice();
    }
}
