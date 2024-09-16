package Services;

import models.City;
import models.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieService {
    private Map<City, List<Movie>> cityMovieList;
    private List<Movie> allMovie;

    MovieService() {
        cityMovieList = new HashMap<>();
        allMovie = new ArrayList<>();
    }

    public void addMovie(Movie movie, City city) {
        allMovie.add(movie);
        List<Movie> movieList = cityMovieList.getOrDefault(city, new ArrayList<>());
        movieList.add(movie);
        cityMovieList.put(city, movieList);
    }
    public List<Movie> getMovieByCity(City city){
        return cityMovieList.getOrDefault(city,new ArrayList<>());
    }

    public Movie getMovieById(String movieId) {
        for (Movie movie : allMovie) {
            if (movie.getMovieId().equals(movieId)) {
                return movie;
            }
        }
        return null;
    }
}
