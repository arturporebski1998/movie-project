package practices.movie.Service;

import practices.movie.Model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();
    void saveMovie(Movie movie);
    void deleteMovie(Movie movie, int id);
}
