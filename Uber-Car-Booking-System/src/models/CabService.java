package models;

public class CabService {
    private CabRepository cabRepository;
    private static CabService INSTANCE;

    private CabService(CabRepository cabRepository) {
        this.cabRepository = cabRepository;
    }

    public static CabService getInstance(final CabRepository cabRepository) {
        if (INSTANCE == null) {
            INSTANCE = new CabService(cabRepository);
        }
        return INSTANCE;
    }

    public void addCab(final String cabNo, final String driverId) {
        cabRepository.addCab(new Cab(cabNo, driverId));
    }

    public void updateLocation(final String cabId, final int x, int y) {
        cabRepository.updateCabLocation(new Location(x, y), cabId);
    }

    public void updateStatus(final String cabId, Status status) {
        cabRepository.updateCabStatus(status, cabId);
    }

    public void addReview(final String cabId, final double rating) {
        cabRepository.addReview(cabId, rating);
    }
}
