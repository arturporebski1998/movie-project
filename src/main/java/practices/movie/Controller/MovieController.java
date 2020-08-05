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
    @GetMapping("movies")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }


    //save movie
    @PostMapping("movies")
    public String saveMovie(@ModelAttribute("movie") Movie movie) {
        movieService.saveMovie(movie);
        return "Done";
    }

    //update movie
    @PutMapping("movies/{id}")
    public ResponseEntity<Object> updateMovie(@RequestBody Movie movie, @PathVariable long id) {

        Optional<Movie> movieOptional = movieRepository.findById(id);

        if (movieOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        movieRepository.save(movie);
        return ResponseEntity.noContent().build();
    }

    //delete movie
    @DeleteMapping("movies/{id}")
    public void deleteMovie(@ModelAttribute("movie") Movie movie, @PathVariable int id) {
        movieService.deleteMovie(movie, id);
    }






}
