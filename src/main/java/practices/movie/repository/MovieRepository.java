package practices.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practices.movie.Model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
