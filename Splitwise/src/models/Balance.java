package models;

public class Balance {
    double getBackAmount;
    double giveBackAmount;

    public Balance() {
        this.getBackAmount = 0.0;
        this.giveBackAmount = 0.0;
    }

    public double getGetBackAmount() {
        return getBackAmount;
    }

    public void setGetBackAmount(double getBackAmount) {
        this.getBackAmount = getBackAmount;
    }

    public double getGiveBackAmount() {
        return giveBackAmount;
    }

    public void setGiveBackAmount(double giveBackAmount) {
        this.giveBackAmount = giveBackAmount;
    }

    public void addGetBackAmount(double amount) {
        getBackAmount += amount;
    }

    public void addGiveBackAmount(double amount) {
        giveBackAmount += amount;
    }
}
