package models;

import java.util.List;
import java.util.Optional;

public interface CabSelectionStrategy {
    Optional<Cab> selectCab(final List<Cab> availableCabs,Location dropLocation);
}
