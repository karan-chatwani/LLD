package models;

public class Review {
    private double avgRating;
    private int count;

    public Review() {
        avgRating = 0.0;
        count = 0;
    }

    public void addRating(double rating) {
        avgRating = (avgRating * count + rating) / (count + 1);
        count++;
    }
    public double getAvgRating(){
        return avgRating;
    }
}
