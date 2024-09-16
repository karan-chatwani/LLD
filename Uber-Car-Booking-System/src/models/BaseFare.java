package models;

public abstract class BaseFare {
    private int price;

    public BaseFare() {

    }

    public BaseFare(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
