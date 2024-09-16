package Services;

import models.City;
import models.Seat;
import models.Show;
import models.Theatre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreService {
    Map<String, Theatre> theatreMap;
    Map<City, List<Theatre>> cityTheatreList;

    TheatreService() {
        theatreMap = new HashMap<>();
        cityTheatreList = new HashMap<>();
    }

    public void addTheatre(Theatre theatre, City city) {
        theatreMap.put(theatre.getTheatreId(), theatre);
        List<Theatre> theatres = cityTheatreList.getOrDefault(city, new ArrayList<>());
        theatres.add(theatre);
        cityTheatreList.put(city, theatres);
    }

    public Map<Theatre, List<Show>> getShowsAndTheatresForMovie(String movieId, City city) {
        Map<Theatre, List<Show>> theatreListMap = new HashMap<>();
        List<Theatre> theatres = cityTheatreList.getOrDefault(city, new ArrayList<>());
        for (Theatre theatre : theatres) {
            List<Show> shows = theatre.getShowbyMovieId(movieId);
            theatreListMap.put(theatre, shows);
        }
        return theatreListMap;
    }

    public Show getShow(String showId, String theatreId) {
        List<Show> shows = theatreMap.get(theatreId).getAllShows();
        for (Show show : shows) {
            if (show.getShowId().equals(showId)) {
                return show;
            }
        }
        return null;
    }

    public List<Seat> getAvailableSeats(String showId, String theatreId) {
        List<Show> shows = theatreMap.get(theatreId).getAllShows();
        for (Show show : shows) {
            if (show.getShowId().equals(showId)) {
                return show.getAvailableSeats();
            }
        }
        return null;
    }

    public void selectAndLockSeat(String showId, String theatreId, String seatId) {
        List<Show> shows = theatreMap.get(theatreId).getAllShows();
        for (Show show : shows) {
            if (show.getShowId().equals(showId)) {
                for (Seat seat : show.getAvailableSeats()) {
                    if (seat.getSeatId().equals(seatId)) {
                        seat.addLock(showId);
                    }
                }
            }
        }
    }
    public void unlockSeat(String showId, String theatreId, String seatId){
        List<Show> shows = theatreMap.get(theatreId).getAllShows();
        for (Show show : shows) {
            if (show.getShowId().equals(showId)) {
                for (Seat seat : show.getAvailableSeats()) {
                    if (seat.getSeatId().equals(seatId)) {
                        seat.addLock(showId);
                    }
                }
            }
        }
    }

}
