package models;

import java.util.List;

public class Rider {
    private String riderId;
    private Location location;
    private List<Ride> rideList;

    public Rider(String riderId) {
        this.riderId = riderId;
    }

    public Location getLocation() {
        return location;
    }

    public void addRide(Ride ride) {
        rideList.add(ride);
    }

    public void updateLocation(Location location) {
        this.location = location;
    }

    public String getRiderId() {
        return riderId;
    }
}
