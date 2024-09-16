package models;

public class TenKmFare extends BaseFare {
    private BaseFare baseFare;
    private int price;

    public TenKmFare(int price, BaseFare baseFare) {
        this.baseFare = baseFare;
        this.price = price;
    }

    public int getPrice() {
        return price + baseFare.getPrice();
    }
}
