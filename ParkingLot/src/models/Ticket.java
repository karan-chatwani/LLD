package models;

import java.util.UUID;

public class Ticket {
    private String tickedId;
    private long startTime;
    private ParkingType parkingType;
    private Vehicle vehicle;
    private ParkingFloor parkingFloor;
    private Slot slot;

    public Ticket(ParkingType parkingType, Vehicle vehicle, ParkingFloor parkingFloor, Slot slot) {
        this.tickedId = UUID.randomUUID().toString();
        this.startTime = System.currentTimeMillis();
        this.parkingType = parkingType;
        this.vehicle = vehicle;
        this.parkingFloor = parkingFloor;
        this.slot = slot;
    }

    public double getFare() {
        long duration = System.currentTimeMillis() - startTime;
        return parkingType.getFare(duration);
    }

    public String getTickedId() {
        return tickedId;
    }

    public ParkingType getParkingType() {
        return parkingType;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public Slot getSlot() {
        return slot;
    }
}
