package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class ParkingLot {
    private String name;
    private List<ParkingFloor> parkingFloorList;
    private static ParkingLot INSTANCE;

    private ParkingLot(String name, List<ParkingFloor> parkingFloorList) {
        this.parkingFloorList = parkingFloorList;
        this.name = name;
    }

    synchronized public static ParkingLot getInstance(String name, List<ParkingFloor> parkingFloorList) {
        if (INSTANCE == null) {
            INSTANCE = new ParkingLot(name, parkingFloorList);
        }
        return INSTANCE;
    }

    public void addParkingFloor(ParkingFloor parkingFloor) {
        parkingFloorList.add(parkingFloor);
    }

    public void removeParkingFloor(ParkingFloor parkingFloor) {
        parkingFloorList.remove(parkingFloor);
    }

    private Ticket getSlotAndBook(Vehicle vehicle) {
        ParkingType parkingType = getParkingTypeOfVehicle(vehicle);
        for (ParkingFloor parkingFloor : parkingFloorList) {
            Slot freeSlot = parkingFloor.getFreeSlot(parkingType);
            if (freeSlot != null) {
                return bookSlot(parkingFloor, parkingType, freeSlot, vehicle);
            }
        }
        return null;
    }

    private Ticket bookSlot(ParkingFloor parkingFloor, ParkingType parkingType, Slot freeSlot, Vehicle vehicle) {
        parkingFloor.occupySlot(parkingType, freeSlot.getSlotId(), vehicle);
        Ticket ticket = new Ticket(parkingType, vehicle, parkingFloor, freeSlot);
        return ticket;
    }

    public Optional<Ticket> occupyVehicle(Vehicle vehicle) {
        Ticket ticket = getSlotAndBook(vehicle);
        if (Objects.nonNull(ticket)) return Optional.of(ticket);
        return Optional.empty();
    }

    public double getFare(Ticket ticket) {
        ticket.getParkingFloor().freeSlot(ticket.getParkingType(), ticket.getSlot().getSlotId());
        return ticket.getFare();
    }

    public PaymentStatus payFare(Ticket ticket, double amount) {
        Payment payment = new Payment(ticket.getTickedId(), ticket.getFare(), amount);
        return payment.process();
    }

    private ParkingType getParkingTypeOfVehicle(Vehicle vehicle) {
        switch (vehicle.getVehicleType()) {
            case TWO_WHEELER -> {
                return ParkingType.SMALL;
            }
            case THREE_WHEELER -> {
                return ParkingType.MEDIUM;
            }
            default -> {
                return ParkingType.LARGE;
            }
        }
    }
}
