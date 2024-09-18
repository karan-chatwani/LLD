package models;

public class DefaultPriceCalculationStrategy implements PriceCalculationStrategy {
    private static double DEFAULT_PRICE_PER_KM = 20;
    private static double BASE_FARE = 40;

    @Override
    public double getEstimatedFate(Cab selectedCab, Location pickLocation, Location dropLocation) {
       return dropLocation.getDistance(pickLocation) * DEFAULT_PRICE_PER_KM + BASE_FARE;
    }
}
