package models;

public interface PriceCalculationStrategy {
    double getEstimatedFate(Cab selectedCab, Location pickLocation, Location dropLocation);
}
