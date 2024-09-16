import java.util.ArrayList;
import java.util.List;

public class IphoneObservable implements StockPriceObservable {
    private int price;
    List<NotificationObserver> observerList;


    public IphoneObservable(int price) {
        this.price = price;
        observerList = new ArrayList<>();

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void addObserver(NotificationObserver notificationObserver) {
        observerList.add(notificationObserver);
    }

    @Override
    public void removeObserver(NotificationObserver notificationObserver) {
        observerList.remove(notificationObserver);
    }

    @Override
    public void sendNotification(int price) {
        for (NotificationObserver notificationObserver : observerList) {
            if (price <= notificationObserver.getAskedPrice()) {
                notificationObserver.update();
            }
        }
    }

    public void updatePrice(int price) {
        setPrice(price);
        sendNotification(price);
    }
}
