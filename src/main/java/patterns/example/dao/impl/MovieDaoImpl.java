package patterns.example.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import patterns.example.dao.MovieDao;
import patterns.example.entity.Movie;
import patterns.example.util.SourceConnection;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MovieDaoImpl implements MovieDao {

    private static final Path Path_MOVIE_DB = FileSystems.getDefault()
            .getPath("src", "main", "resources", "movie.txt");
    private static final Logger LOGGER = LoggerFactory.getLogger(MovieDaoImpl.class);

    @Override
    public void create(Movie movie) {
        try (var writer = SourceConnection.writeToDB(Path_MOVIE_DB)) {
            writer.write(movie.toString());
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public List<String> findByMovieType(Movie.MovieType type) {
        List<String> movies = new ArrayList<>();
        try (var reader = SourceConnection.readFromDB(Path_MOVIE_DB)) {
            return reader.lines().filter(line -> line.contains(type.name()))
                    .toList();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return movies;
    }

    @Override
    public List<String> findByActor(String actor) {
        List<String> movies = new ArrayList<>();
        try (var reader = SourceConnection.readFromDB(Path_MOVIE_DB)) {
            return reader.lines().filter(line -> line.contains(actor))
                    .toList();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return movies;
    }
}
