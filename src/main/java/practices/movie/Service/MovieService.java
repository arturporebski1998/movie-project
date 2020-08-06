package practices.movie.Service;

import practices.movie.Model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();
    void saveMovie(Movie movie);
    void deleteMovie(long movieId);
    void checkIfEmptyField(Movie movie, int id);
}
