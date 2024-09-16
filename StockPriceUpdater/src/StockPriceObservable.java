public interface StockPriceObservable {
    public void addObserver(NotificationObserver notificationObserver);
    public void removeObserver(NotificationObserver notificationObserver);
    public void sendNotification(int price);
}
