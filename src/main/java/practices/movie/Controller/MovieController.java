package practices.movie.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
    public ResponseEntity<Movie> getAllMovies() {
        return new ResponseEntity(this.movieRepository.findAll(), HttpStatus.OK);
    }

    //save movie
    @RequestMapping(value = "/movies", method = RequestMethod.POST)
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        return new ResponseEntity(this.movieRepository.save(movie), HttpStatus.OK);
    }


    @RequestMapping(value = "/movies/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Movie> updateMovie(@PathVariable(value = "id") Long movieId, @Validated @RequestBody Movie movieDetails){
        Movie movie = movieRepository.getOne(movieId);

            movie.setTitle(movieDetails.getTitle());
            movie.setDate(movieDetails.getDate());
            movie.setAvgRate(movieDetails.getAvgRate());
            movie.setGenre(movieDetails.getGenre());
            movie.setDirector(movieDetails.getDirector());
            movie.setCountry(movieDetails.getCountry());
            movie.setDescription(movieDetails.getDescription());


        return new ResponseEntity<>(this.movieRepository.save(movie), HttpStatus.OK);
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