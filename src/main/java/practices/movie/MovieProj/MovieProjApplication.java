package practices.movie.MovieProj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"practices.movie.Model"})
public class MovieProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieProjApplication.class, args);
	}

}
