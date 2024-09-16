package models;

public class Slot {
    private String slotId;
    private Vehicle vehicle;
    private ParkingType parkingType;

    public Slot(String slotId, ParkingType parkingType) {
        this.slotId = slotId;
        this.parkingType = parkingType;
        vehicle = null;
    }

    public String getSlotId() {
        return this.slotId;
    }

    public void addVehicleToSlot(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void removeVehicleFromSlot() {
        this.vehicle = null;
    }

    public boolean isSlotFree() {
        return vehicle == null;
    }
}
