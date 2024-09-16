package models;

public class Booking {
    private String bookingId;
    private String showId;
    private String seatId;
    private String theatre;

    public Booking(String bookingId, String showId, String seatId, String theatre) {
        this.bookingId = bookingId;
        this.showId = showId;
        this.seatId = seatId;
        this.theatre = theatre;
    }
}
