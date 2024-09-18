package models;

import java.util.List;
import java.util.Optional;

public class RatingBasedCabSelectionStrategy implements CabSelectionStrategy {
    @Override
    public Optional<Cab> selectCab(final List<Cab> availableCabs, final Location dropLocation) {
        if (availableCabs.size() == 0) {
            return Optional.empty();
        }
        Cab selectedCab = availableCabs.get(0);
        for (Cab cab : availableCabs) {
            if (cab.getReview().getAvgRating() > selectedCab.getReview().getAvgRating()) {
                selectedCab = cab;
            }
        }
        return Optional.of(selectedCab);
    }
}
