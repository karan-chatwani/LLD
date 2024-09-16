package models;


import java.util.ArrayList;
import java.util.List;

public class Show {
    private String showId;
    private String movieId;
    private Screen screen;
    private List<String> bookedSeatId;

    public Show(Screen screen, String showId, String movieId) {
        this.screen = screen;
        this.showId = showId;
        this.movieId = movieId;
        bookedSeatId = new ArrayList<>();
    }

    public Screen getScreen() {
        return screen;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public void bookSeat(String seatId) {
        bookedSeatId.add(seatId);
    }

    public List<Seat> getAvailableSeats() {
        List<Seat> availableSeats = new ArrayList<>();
        for (Seat seat : screen.getSeats()) {
            if (bookedSeatId.contains(seat.getSeatId())) continue;
            ;
            availableSeats.add(seat);
        }
        return availableSeats;
    }

    public boolean isSeatsAvailable(String seatId) {
        return !bookedSeatId.contains(seatId);
    }
}
