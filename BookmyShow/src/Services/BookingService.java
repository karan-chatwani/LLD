package Services;

import models.Booking;
import models.City;
import models.Movie;
import models.Screen;
import models.Seat;
import models.Show;
import models.Theatre;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class BookingService {
    private MovieService movieService;
    private TheatreService theatreService;
    private Map<String, Booking> bookingMap;

    BookingService() {
        movieService = new MovieService();
        theatreService = new TheatreService();
        bookingMap = new HashMap<>();
    }

    public void book(String showId, String theatreId, String seatId) throws Exception {
        String bookingId = UUID.randomUUID().toString();
        Show show = theatreService.getShow(showId, theatreId);
        Booking booking = new Booking(bookingId, showId, seatId, theatreId);
        show.bookSeat(seatId);
        bookingMap.put(bookingId, booking);
        theatreService.unlockSeat(showId, theatreId, seatId);
    }

    public static void main(String[] args) {
        BookingService bookingService = new BookingService();
        bookingService.initialize();
        System.out.println("Hello world!");
    }

    private void initialize() {
        Movie movie1 = new Movie("M1", "KKJK", 120);
        Movie movie2 = new Movie("M2", "MKPL", 120);
        Movie movie3 = new Movie("M3", "BBBBL", 120);
        movieService.addMovie(movie1, City.KOLKATA);
        movieService.addMovie(movie3, City.KOLKATA);
        movieService.addMovie(movie2, City.PUNE);
        movieService.addMovie(movie3, City.PUNE);
        Screen screen1 = new Screen("S1");
        Screen screen2 = new Screen("S2");
        for (int i = 1; i <= 10; i++) {
            String z = String.valueOf(i);
            Seat seat = new Seat("ST" + z, "A");
            screen1.addSeats(seat);
            screen2.addSeats(seat);
        }
        Show show1 = new Show(screen1, "SHW1", "M1");
        Show show2 = new Show(screen2, "SHW2", "M2");
        Show show3 = new Show(screen2, "SHW3", "M3");

        Theatre theatre1 = new Theatre("T1");
        Theatre theatre2 = new Theatre("T2");
        theatre1.addShow(show1);
        theatre1.addShow(show2);
        theatre2.addShow(show2);
        theatre2.addShow(show3);
        theatreService.addTheatre(theatre1, City.KOLKATA);
        theatreService.addTheatre(theatre2, City.PUNE);
        List<Movie> movieList = movieService.getMovieByCity(City.PUNE);
        Movie movie = movieList.get(0);
        Map<Theatre, List<Show>> theatreListMap = theatreService.getShowsAndTheatresForMovie(movie.getMovieId(), City.PUNE);
        List<Show> shows = theatreListMap.get(theatre2);
        Show show = shows.get(0);
        List<Seat> availableSeats = theatreService.getAvailableSeats(show.getShowId(), theatre2.getTheatreId());
        Seat seat = availableSeats.get(0);
        theatreService.selectAndLockSeat(show.getShowId(), theatre2.getTheatreId(), seat.getSeatId());
        try {
            book(show.getShowId(), "T2", seat.getSeatId());
            System.out.println("Completed");
            book(show.getShowId(), "T2", seat.getSeatId());
            System.out.println("Completed");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
