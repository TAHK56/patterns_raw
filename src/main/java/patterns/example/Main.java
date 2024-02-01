package patterns.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import patterns.example.dao.CustomerDao;
import patterns.example.dao.MovieDao;
import patterns.example.dao.impl.CustomerDaoImpl;
import patterns.example.dao.impl.MovieDaoImpl;
import patterns.example.entity.Customer;
import patterns.example.entity.Movie;
import patterns.example.entity.Rental;
import patterns.example.util.UserInputs;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static patterns.example.entity.Movie.MovieType.CHILDREN;
import static patterns.example.entity.Movie.MovieType.NEW_RELEASE;
import static patterns.example.entity.Movie.MovieType.REGULAR;


public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        preview();
        showFilms();
    }

    private static void preview() {
        LOGGER.info("Hi! Do you want to work with movie files or with customer files?\n");
        LOGGER.info("Enter your answer 1-movie; 2-customer\n");

        String answer = UserInputs.getUserInput();
        if (Objects.nonNull(answer) && answer.equals("1")) {
            fillMovieDB();
        } else if (Objects.nonNull(answer) && answer.equals("2")) {
            fillCustomerDB();
        }

    }

    private static void fillMovieDB() {
        MovieDao dao = new MovieDaoImpl();
        LOGGER.info("You choose movie\n");
        LOGGER.info("For create movie, you must enter: title and movie type!! Other optional: country, " +
                    "shortDescription, movieDirector, actors....\n");
        LOGGER.info("Title\n");
        String title = UserInputs.getUserInput();
        LOGGER.info("Movie type\n");
        String type = UserInputs.getUserInput();
        LOGGER.info("Country(or skip enter)\n");
        String country = UserInputs.getUserInput();
        LOGGER.info("Short description (or skip enter)\n");
        String shortDescription = UserInputs.getUserInput();
        LOGGER.info("Movie director(or skip enter)\n");
        String movieDirector = UserInputs.getUserInput();
        LOGGER.info("Actors (or skip enter");
        List<String> actors = new ArrayList<>();
        String actor;
        while (Objects.nonNull(actor = UserInputs.getUserInput())) {
            actors.add(actor);
        }
        Movie movie = new Movie.Builder(title, Movie.MovieType.valueOf(type.toUpperCase())).country(country)
                .shortDescription(shortDescription).movieDirector(movieDirector).actors(actors.toArray(String[]::new))
                .build();
        dao.create(movie);
    }

    private static void fillCustomerDB() {
        CustomerDao dao = new CustomerDaoImpl();
        LOGGER.info("You choose customer\n");
        List<Rental> rentals = List.of(new Rental(new Movie.Builder("Rambo", REGULAR).build(), 1),
                new Rental(new Movie.Builder("Lord of the Rings", NEW_RELEASE).build(), 4),
                new Rental(new Movie.Builder("Harry Potter", CHILDREN).build(), 5));
        Customer customer = new Customer("John Doe", rentals);
        dao.create(customer);

    }

    private static void showFilms() {
        MovieDao dao = new MovieDaoImpl();
        dao.findByActor("Tom Cruz");
        dao.findByMovieType(CHILDREN);
    }

}