import java.util.concurrent.TimeUnit;

public class TockenBucketRateLimitter implements IRateLimitter {
    private final long maxBucketSize;
    private final long refillRate;//in seconds
    private long lastRefillTime;
    private long curBucketSize;

    public TockenBucketRateLimitter(long maxBucketSize, long refillRate, long lastRefillTime) {
        this.maxBucketSize = maxBucketSize;
        this.refillRate = refillRate;
        this.lastRefillTime = System.currentTimeMillis();
        curBucketSize = maxBucketSize;
    }

    @Override
    public synchronized boolean isAllowed(String userId) {
        refill();
        if (curBucketSize >= 1) {
            curBucketSize--;
            return true;
        }
        return false;
    }

    private void refill() {
        long now = System.currentTimeMillis();
        long timePassed = now - lastRefillTime;
        long tokenToBeAdded = refillRate * (timePassed / 1000);
        curBucketSize = Math.min(maxBucketSize, curBucketSize + tokenToBeAdded);
        lastRefillTime = now;
    }
}
