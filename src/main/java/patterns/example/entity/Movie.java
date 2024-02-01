package patterns.example.entity;

import patterns.example.statement.ChildrenPrice;
import patterns.example.statement.ComedyPrice;
import patterns.example.statement.DramaPrice;
import patterns.example.statement.NewReleasePrice;
import patterns.example.statement.Price;
import patterns.example.statement.RegularPrice;
import patterns.example.statement.ThrillerPrice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Movie implements BaseEntity {
    private final String title;
    private MovieType priceCode;
    private final String country;
    private final String shortDescription;
    private final String movieDirector;
    private final Set<String> actors;


    public enum MovieType {
        REGULAR(new RegularPrice()), NEW_RELEASE(new NewReleasePrice()), CHILDREN(new ChildrenPrice()),
        DRAMA(new DramaPrice()), COMEDY(new ComedyPrice()), THRILLER(new ThrillerPrice());

        private final Price price;

        MovieType(Price price) {
            this.price = price;
        }

        public Price getPrice() {
            return price;
        }
    }

    private Movie(Builder builder) {
        title = builder.title;
        priceCode = builder.priceCode;
        country = builder.country;
        shortDescription = builder.shortDescription;
        movieDirector = builder.movieDirector;
        actors = builder.actors;
    }

    public MovieType getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(MovieType priceCode) {
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }


    public double calculateAmount(int daysRented) {
        return priceCode.getPrice().calculateAmount(daysRented);
    }

    public int calculateRenterPoints(int daysRented) {
        return priceCode.getPrice().calculateRenterPoints(daysRented);
    }

    public static class Builder {
        private final String title;
        private final MovieType priceCode;
        private String country;
        private String shortDescription;
        private String movieDirector;
        private Set<String> actors;

        public Builder(String title, MovieType priceCode) {
            this.title = title;
            this.priceCode = priceCode;
        }

        public Builder country(String name) {
            country = name;
            return this;
        }

        public Builder shortDescription(String description) {
            shortDescription = description;
            return this;
        }

        public Builder movieDirector(String name) {
            movieDirector = name;
            return this;
        }

        public Builder actors(String... names) {
            actors = new HashSet<>(Arrays.asList(names));
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }

    @Override
    public String toString() {
        return "Movie{" +
               "title='" + title + '\'' +
               ", priceCode=" + priceCode +
               ", country='" + country + '\'' +
               ", shortDescription='" + shortDescription + '\'' +
               ", movieDirector='" + movieDirector + '\'' +
               ", actors=" + actors +
               '}';
    }
}