public class EmailObserver extends NotificationObserver {
    private String emailId;
    private StockPriceObservable stockPriceObservable;

    public EmailObserver(String emailId, int priceWanted, StockPriceObservable stockPriceObservable) {
        super(priceWanted);
        this.emailId = emailId;
        this.stockPriceObservable = stockPriceObservable;
    }

    @Override
    public void update() {
        System.out.println("Sending email to " + emailId);
    }
}
