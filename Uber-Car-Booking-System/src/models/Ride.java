package models;

public class Ride {
    private String rideId;
    private Cab cab;
    private Rider rider;
    private Location pickup;
    private Location destination;
    private double baseFare;
    private RideStatus rideStatus;

    public Ride(String rideId, Rider rider, Location pickup, Location destination, double baseFare) {
        this.rideId = rideId;
        this.rider = rider;
        this.pickup = pickup;
        this.destination = destination;
        this.baseFare = baseFare;
        this.rideStatus = RideStatus.ACCEPTED;
    }

    public void updateStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }

    public String getRideId() {
        return rideId;
    }

    public Cab getCab() {
        return cab;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }

    public void setRideId(String rideId) {
        this.rideId = rideId;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public Location getPickup() {
        return pickup;
    }

    public void setPickup(Location pickup) {
        this.pickup = pickup;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }

    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }
}
