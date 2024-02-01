package patterns.example.dao;

import patterns.example.entity.Movie;

import java.util.List;

public interface MovieDao extends BaseDao<Movie> {

    List<String> findByMovieType(Movie.MovieType type);

    List<String> findByActor(String actor);
}
