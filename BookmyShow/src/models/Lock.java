package models;

public class Lock {
    private String showId;
    private String seatId;
    private long ttl;
    private long locketAt;

    public Lock(String showId, String seatId, long ttl) {
        this.showId = showId;
        this.seatId = seatId;
        this.ttl = ttl;
        this.locketAt = System.currentTimeMillis();
    }

    public boolean isLockExpired() {
        return System.currentTimeMillis() - locketAt > ttl;
    }
}
