package models;

public abstract class Vehicle {
    private VehicleType vehicleType;

    public Vehicle(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() {
        return this.vehicleType;
    }
}
