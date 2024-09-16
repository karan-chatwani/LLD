public class PushNotificationObserver extends NotificationObserver {
    private String phoneNo;
    private StockPriceObservable stockPriceObservable;

    public PushNotificationObserver(String phoneNo, int priceWanted, StockPriceObservable stockPriceObservable) {
        super(priceWanted);
        this.phoneNo = phoneNo;
        this.stockPriceObservable = stockPriceObservable;
    }

    @Override
    public void update() {
        System.out.println("Sending pust notification to " + phoneNo);

    }
}
