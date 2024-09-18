package models;

public class Cab {
    private String cabNo;
    private String driverId;
    private Location currentLocation;
    private Status status;
    private Review review;

    public Cab(String cabNo, String driverId) {
        this.cabNo = cabNo;
        this.driverId = driverId;
        review = new Review();
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void updateLocation(Location location) {
        this.currentLocation = location;
    }

    public void updateStatus(Status status) {
        this.status = status;
    }

    public boolean isAvailable() {
        return Status.ONLINE == status;
    }

    public String getCabNo() {
        return cabNo;
    }

    public boolean acceptRide(Ride ride) {
        ride.setCab(this);
        return true;
    }

    public void addReview(double rating) {
        review.addRating(rating);
    }
    public Review getReview(){
        return review;
    }
}
