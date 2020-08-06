package practices.movie.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practices.movie.Model.Movie;
import practices.movie.Repository.MovieRepository;
import java.util.List;
import java.util.Optional;

import practices.movie.Service.MovieService;


@RestController
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieService movieService;

    //get movie
    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }


    //save movie
    @RequestMapping(value = "/movies", method = RequestMethod.POST)
    public Movie saveMovie(@RequestBody Movie movie) {
        return this.movieRepository.save(movie);
    }

    //update movie
    @RequestMapping(value = "/movies/{id}", method = RequestMethod.PUT)
        public void updateMovie(@PathVariable("id") Long movieId, @RequestBody Movie movie) {
           Movie movieUp =  movieRepository.getOne(movieId);
           if (movie == null) {
               throw new IllegalStateException("no product with id" + movieId);
           }
           movie.setId(movieId);
           movieRepository.save(movie);
    }

    //delete movie
    @RequestMapping(value = "/movies/{id}", method = RequestMethod.DELETE)
    public void deleteMovie(@PathVariable("id") Long movieId){
        movieService.deleteMovie(movieId);
    }

}
