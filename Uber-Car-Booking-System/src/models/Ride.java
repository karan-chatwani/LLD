package models;

public class Ride {
    private String rideId;
    private Driver driver;
    private Rider rider;
    private Location pickup;
    private Location destination;
    private BaseFare baseFare;
    private RideStatus rideStatus;

    public void updateStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }

    public String getRideId() {
        return rideId;
    }

    public void setRideId(String rideId) {
        this.rideId = rideId;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
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

    public BaseFare getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(BaseFare baseFare) {
        this.baseFare = baseFare;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }

    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }
}
