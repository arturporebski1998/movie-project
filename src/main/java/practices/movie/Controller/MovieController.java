package practices.movie.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public String saveMovie(@RequestBody Movie movie) {
        movieService.saveMovie(movie);
        return "Done";
    }

    //update movie
    @RequestMapping(value = "/movies/{}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateMovie(@RequestBody Movie movie, @PathVariable long id) {

        Optional<Movie> movieOptional = movieRepository.findById(id);

        if (movieOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        movieRepository.save(movie);
        return ResponseEntity.noContent().build();
    }

    //delete movie
    @RequestMapping(value = "/movies/{}", method = RequestMethod.DELETE)
    public void deleteMovie(@ModelAttribute("movie") Movie movie, @PathVariable int id) {
        movieService.deleteMovie(movie, id);
    }


}
