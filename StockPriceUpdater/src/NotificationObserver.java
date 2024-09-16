public abstract class NotificationObserver {
    private int priceWanted;

    public NotificationObserver(int priceWanted) {
        this.priceWanted = priceWanted;
    }

    public int getAskedPrice() {
        return priceWanted;
    }

    public abstract void update();
}
