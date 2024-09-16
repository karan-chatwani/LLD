package models;

import java.util.Map;
import java.util.TreeSet;

public class NormalParkingStrategy implements ParkingStrategy {
    Map<ParkingType, TreeSet<String>> slotMap;

    public NormalParkingStrategy(Map<ParkingType, TreeSet<String>> slotMap) {
        this.slotMap = slotMap;
    }

    @Override
    public void addSlot(ParkingType parkingType, String slotId) {
        TreeSet<String> slotSet = slotMap.getOrDefault(parkingType, new TreeSet<>());
        slotSet.add(slotId);
        slotMap.put(parkingType, slotSet);
    }

    @Override
    public void removeSlot(ParkingType parkingType, String slotId) {
        slotMap.get(parkingType).remove(slotId);
    }

    @Override
    public String getNextAvailableSlot(ParkingType parkingType) {
        try {
            return slotMap.get(parkingType).first();
        } catch (Exception e) {
            return null;
        }
    }
}
