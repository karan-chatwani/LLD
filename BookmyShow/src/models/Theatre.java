package models;


import java.util.ArrayList;
import java.util.List;

public class Theatre {


    private String theatreId;
    private List<Screen> screenList;
    private List<Show> showList;

    public Theatre(String theatreId) {
        this.theatreId = theatreId;
        showList = new ArrayList<>();
        screenList = new ArrayList<>();
    }

    public String getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(String theatreId) {
        this.theatreId = theatreId;
    }

    public void addShow(Show show) {
        showList.add(show);
    }

    public void addScreen(Screen screen) {
        screenList.add(screen);
    }

    public List<Show> getShowbyMovieId(String movieId) {
        List<Show> shows = new ArrayList<>();
        for (Show show : showList) {
            if (show.getMovieId().equals(movieId)) {
                shows.add(show);
            }
        }
        return shows;
    }

    public List<Show> getAllShows() {
        return showList;
    }
}
