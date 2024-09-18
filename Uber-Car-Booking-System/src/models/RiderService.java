package models;

import java.util.List;

public class RiderService {
    private RiderRepository riderRepository;
    private static RiderService INSTANCE;

    private RiderService(RiderRepository riderRepository) {
        this.riderRepository = riderRepository;
    }

    public static RiderService getInstance(final RiderRepository riderRepository) {
        if (INSTANCE == null) {
            INSTANCE = new RiderService(riderRepository);
        }
        return INSTANCE;
    }

    public void addRider(final String riderId) {
        riderRepository.addRider(new Rider(riderId));
    }

    public void updateLocation(final String riderId, final int x, int y) {
        riderRepository.updateLocationRider(new Location(x, y), riderId);
    }

    public List<Ride> getRideHistory(final String riderId) {
        return riderRepository.getRider(riderId).getRideList();
    }
}
