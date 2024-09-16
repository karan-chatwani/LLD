import models.Driver;
import models.Location;
import models.Rider;

import java.util.List;
import java.util.Map;

public class RideMatchingService {
    private Map<String, Rider> riderMap;
    private Map<String, Driver> driverMap;

    public void updateLocationDriver(String driverId, Location updatedLocation){
        driverMap.get(driverId).updateLocation(updatedLocation);
    }
    public void updateLocationRider(String riderId, Location updatedLocation){
        riderMap.get(riderId).updateLocation(updatedLocation);
    }
    public void

}
