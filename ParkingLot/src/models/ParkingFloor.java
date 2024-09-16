package models;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ParkingFloor {
    private int parkingFloorNumber;
    private Map<ParkingType, Map<String, Slot>> slotMap;
    private ParkingStrategy parkingStrategy;

    public ParkingFloor(int parkingFloorNumber, Map<ParkingType, Map<String, Slot>> slotMap) {
        this.parkingFloorNumber = parkingFloorNumber;
        this.slotMap = slotMap;
        initParkingStrategy(slotMap);
    }

    private void initParkingStrategy(Map<ParkingType, Map<String, Slot>> slotMap) {
        Map<ParkingType, TreeSet<String>> parkingTypeTreeSetMap = new HashMap<>();
        for (Map.Entry<ParkingType, Map<String, Slot>> entry : slotMap.entrySet()) {
            Map<String, Slot> slotMap1 = entry.getValue();
            for (String slotId : slotMap1.keySet()) {
                TreeSet<String> slotSet = parkingTypeTreeSetMap.getOrDefault(entry.getKey(), new TreeSet<>());
                slotSet.add(slotId);
                parkingTypeTreeSetMap.put(entry.getKey(), slotSet);
            }
        }
        parkingStrategy = new NormalParkingStrategy(parkingTypeTreeSetMap);
    }

    public void addSlots(ParkingType parkingType, Slot slot) {
        Map<String, Slot> stringSlotMap = slotMap.getOrDefault(parkingType, new HashMap<>());
        stringSlotMap.put(slot.getSlotId(), slot);
        slotMap.put(parkingType, stringSlotMap);
    }

    public Slot getFreeSlot(ParkingType parkingType) {
        String slotId = parkingStrategy.getNextAvailableSlot(parkingType);
       return slotId == null ? null : slotMap.get(parkingType).get(slotId);
    }

    public void occupySlot(ParkingType parkingType, String slotId, Vehicle vehicle) {
        parkingStrategy.removeSlot(parkingType, slotId);
        slotMap.get(parkingType).get(slotId).addVehicleToSlot(vehicle);
    }

    public void freeSlot(ParkingType parkingType, String slotId) {
        parkingStrategy.addSlot(parkingType, slotId);
        slotMap.get(parkingType).get(slotId).removeVehicleFromSlot();
    }

}
