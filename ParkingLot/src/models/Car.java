package models;

public class Car extends Vehicle {
    private String carNo;
    private String carName;

    public Car(String carNo, String carName) {
        super(VehicleType.FOUR_WHEELER);
        this.carNo = carNo;
        this.carName = carName;
    }
}
