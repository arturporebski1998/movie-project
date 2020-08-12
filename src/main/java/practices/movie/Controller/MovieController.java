package practices.movie.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import practices.movie.Model.Movie;
import practices.movie.Repository.MovieRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import practices.movie.Service.MovieService;


@RestController
@CrossOrigin(origins = "*")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieService movieService;

    //get movie
    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public ResponseEntity<LinkedList<Movie>> getAllMovies() {
        return new ResponseEntity(this.movieRepository.findAll(), HttpStatus.OK);
    }

    //save movie
    @RequestMapping(value = "/movies", method = RequestMethod.POST)
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        return new ResponseEntity(this.movieRepository.save(movie), HttpStatus.OK);
    }


    @RequestMapping(value = "/movies/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Movie> updateMovie(@PathVariable(value = "id") Long movieId, @RequestBody Movie movieDetails) {
        Optional<Movie> optMovie = movieRepository.findById(movieId);
        if (optMovie.isPresent()) {
            return new ResponseEntity<>(this.movieRepository.save(movieDetails), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }



    //delete movie
    @RequestMapping(value = "/movies/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Movie> deleteMovie(@PathVariable("id") Long movieId){
        movieRepository.deleteById(movieId);
        return new ResponseEntity(HttpStatus.OK);
    }

    //update movie
//    @RequestMapping(value = "/movies/{id}", method = RequestMethod.PUT)
//    public void updateMovie(@PathVariable("id") Long movieId, @RequestBody Movie movie) {
//        Movie movieUp =  movieRepository.getOne(movieId);
//        if (movie == null) {
//            throw new IllegalStateException("no product with id" + movieId);
//        }
//        movie.setId(movieId);
//        movieRepository.save(movie);
//    }


}