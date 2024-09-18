package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class RideService {
    private CabRepository cabRepository;
    private RiderRepository riderRepository;
    private CabSelectionStrategy cabSelectionStrategy;
    private PriceCalculationStrategy priceCalculationStrategy;
    private static final int MAX_DISTANCE_SEARCH = 10;
    private Map<String, Ride> rideMap;

    public RideService(CabRepository cabRepository, RiderRepository riderRepository, CabSelectionStrategy cabSelectionStrategy, PriceCalculationStrategy priceCalculationStrategy) {
        this.cabRepository = cabRepository;
        this.riderRepository = riderRepository;
        this.cabSelectionStrategy = cabSelectionStrategy;
        this.priceCalculationStrategy = priceCalculationStrategy;
        rideMap = new HashMap<>();
    }

    public Ride createRide(String riderId, Location destination) {
        Location riderLocation = riderRepository.getRider(riderId).getLocation();
        List<Cab> nearByCabs = cabRepository.getCabsUptoDistance(riderLocation, MAX_DISTANCE_SEARCH);
        List<Cab> availableCabs = nearByCabs.stream()
                .filter(eachCab -> eachCab.isAvailable())
                .collect(Collectors.toList());
        Optional<Cab> selectedCab = cabSelectionStrategy.selectCab(availableCabs, destination);
        if (selectedCab.isEmpty()) {
            throw new RuntimeException("No cab found");
        }
        double fare = priceCalculationStrategy.getEstimatedFate(selectedCab.get(), riderLocation, destination);
        final String rideId = UUID.randomUUID().toString();
        Ride ride = new Ride(rideId, riderRepository.getRider(riderId), riderLocation, destination, fare);
        selectedCab.get().acceptRide(ride);
        rideMap.put(rideId, ride);
        return ride;
    }

    public void updateRideStatus(String rideId, RideStatus status) {
        rideMap.get(rideId).updateStatus(status);
    }

}
