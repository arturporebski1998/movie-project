package practices.movie.Model;

import javax.persistence.*;


@Entity
@Table(name="movies")
public class Movie {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public double getAvgRate() {
        return avgRate;
    }

    public void setAvgRate(double avgRate) {
        this.avgRate = avgRate;
    }

    public String getFilmGenre() {
        return filmGenre;
    }

    public void setFilmGenre(String filmGenre) {
        this.filmGenre = filmGenre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Movie(int id, int date, double avgRate, String filmGenre, String director, String country, String description) {
        this.id = id;
        this.date = date;
        this.avgRate = avgRate;
        this.filmGenre = filmGenre;
        this.director = director;
        this.country = country;
        this.description = description;
    }

    @Id
    private int id;

    @Column(name="col1")
    private int date;

    @Column
    double avgRate;

    @Column
    private String filmGenre;

    @Column
    private String director;

    @Column
    private String country;

    @Column
    private String description;



}
