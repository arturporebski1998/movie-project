package practices.movie.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import practices.movie.Model.Movie;
import practices.movie.Repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieService movieService;

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public void saveMovie(Movie movie) {
        this.movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(long movieId) {
        movieRepository.deleteById(movieId);
    }

    @Override
    public void checkIfEmptyField(Movie movie, int id) {

    }


}
