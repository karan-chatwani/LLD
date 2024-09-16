package models;

public class Movie {
    private String movieId;
    private String movieName;
    private int duration;

    public Movie(String movieId, String movieName, int duration) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.duration = duration;
    }

    public String getMovieId() {
        return movieId;
    }
}
