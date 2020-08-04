package practices.movie.Model;

public class MovieModel {
    int id;
    int date;
    double avgRate;
    String filmGenre;
    String director;
    String country;
    String description;

    public MovieModel (int id, int date, double avgRate, String filmGenre, String director, String country, String description) {
        this.id = id;
        this.date = date;
        this.avgRate = avgRate ;
        this.filmGenre = filmGenre;
        this.director = director;
        this.country = country;
        this. description = description;
    }
}
