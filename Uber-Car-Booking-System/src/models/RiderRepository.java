package models;

import java.util.HashMap;
import java.util.Map;

public class RiderRepository {
    private Map<String, Rider> riderMap;

    public RiderRepository() {
        riderMap = new HashMap<>();
    }

    public void addRider(final Rider rider) {
        if (riderMap.containsKey(rider.getRiderId())) {
            throw new RuntimeException();
        }
        riderMap.put(rider.getRiderId(), rider);
    }

    public void updateLocationRider(final Location location, String riderId) {
        riderMap.get(riderId).updateLocation(location);
    }

    public Rider getRider(final String riderId) {
        return riderMap.get(riderId);
    }
}
