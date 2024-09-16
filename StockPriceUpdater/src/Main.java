public class Main {
    public static void main(String[] args) {
        IphoneObservable stockPriceObservable = new IphoneObservable(90000);
        NotificationObserver notificationObserver = new EmailObserver("kchat", 80000, stockPriceObservable);
        NotificationObserver notificationObserver2 = new EmailObserver("iit", 70000, stockPriceObservable);
        NotificationObserver notificationObserver3 = new PushNotificationObserver("6296", 75000, stockPriceObservable);
        stockPriceObservable.addObserver(notificationObserver);
        stockPriceObservable.addObserver(notificationObserver2);
        stockPriceObservable.addObserver(notificationObserver3);
        stockPriceObservable.updatePrice(74000);
        System.out.println("Hello world!");
    }
}