import java.util.concurrent.TimeUnit;

public interface RateLimitterStrategy {
    int noOfRequests(String userId, int time, TimeUnit unit);
}
