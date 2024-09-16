package models;

public interface ParkingStrategy {
    public void addSlot(ParkingType parkingType,String slotId);

    public void removeSlot(ParkingType parkingType,String slotId);

    public String getNextAvailableSlot(ParkingType parkingType);
}
