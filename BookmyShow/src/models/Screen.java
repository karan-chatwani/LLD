package models;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    private String screenId;
    private List<Seat> seatList;

    public Screen(String screenId) {
        this.screenId = screenId;
        seatList = new ArrayList<>();
    }

    public void addSeats(Seat seat) {
        seatList.add(seat);
    }
    public List<Seat> getSeats(){
        return seatList;
    }
}
