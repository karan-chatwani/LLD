package models;

import java.util.List;

public class Rider {
    private String riderId;
    private Location location;
    private List<Ride> rideList;

    public void addRide(Ride ride) {
        rideList.add(ride);
    }

    public void updateLocation(Location location) {
        this.location = location;
    }
}
