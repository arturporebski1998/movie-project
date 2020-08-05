package practices.movie.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import practices.movie.Model.Movie;
import practices.movie.repository.MovieRepository;

@RestController
public class MovieController {
    @Autowired
    MovieRepository repository;

    @RequestMapping("/save")
    public String addMovie() {
        repository.save(new Movie("Interstellar"));
        return "Done";
    }
}
