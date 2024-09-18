package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CabRepository {
    private Map<String, Cab> cabMap;

    public CabRepository() {
        cabMap = new HashMap<>();
    }

    public void addCab(final Cab cab) {
        if (cabMap.containsKey(cab.getCabNo())) {
            throw new RuntimeException();
        }
        cabMap.put(cab.getCabNo(), cab);
    }

    public Cab getCab(final String cabId) {
        return cabMap.get(cabId);
    }

    public List<Cab> getCabsUptoDistance(final Location userLocation, final double distance) {
        List<Cab> availableCabs = new ArrayList<>();
        for (Cab cab : cabMap.values()) {
            if (cab.getCurrentLocation().getDistance(userLocation) <= distance) {
                availableCabs.add(cab);
            }
        }
        return availableCabs;
    }

    public void updateCabStatus(final Status status, final String cabId) {
        cabMap.get(cabId).updateStatus(status);
    }

    public void updateCabLocation(final Location location, final String cabId) {
        cabMap.get(cabId).updateLocation(location);
    }

    public void addReview(String cabId, double rating) {
        cabMap.get(cabId).addReview(rating);
    }
}
