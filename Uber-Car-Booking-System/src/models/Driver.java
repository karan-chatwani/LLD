package models;

public class Driver {
    private String driverId;
    private String driverName;
    private Location currentLocation;
    private Cab cab;
    private Status status;

    public void updateLocation(Location location) {
        this.currentLocation = location;
    }

    public void updateStatus(Status status) {
        this.status = status;
    }

    public boolean isAvailable() {
        return Status.ONLINE == status;
    }

    public boolean acceptRide(Ride ride) {
        ride.setDriver(this);
        return true;
    }
}
