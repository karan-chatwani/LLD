package models;

public class Seat {
    private String seatId;
    private String seatType;
    private Lock lock;

    public Seat(String seatId, String seatType) {
        this.seatId = seatId;
        this.seatType = seatType;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public synchronized void addLock(String showId) {
        if (lock != null && !lock.isLockExpired()) {
            throw new RuntimeException("Temporarily unavilable");
        }
        lock = new Lock(showId, seatId, 1000);
    }

    public void unlockSeat() {
        lock = null;
    }

}
