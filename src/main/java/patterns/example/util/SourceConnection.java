package patterns.example.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;

public final class SourceConnection {


    private SourceConnection() {
    }

    public static BufferedWriter writeToDB(Path path) throws IOException {
        return Files.newBufferedWriter(path, StandardCharsets.UTF_8, CREATE, WRITE, APPEND);
    }

    public static BufferedReader readFromDB(Path path) throws IOException {
        return Files.newBufferedReader(path, StandardCharsets.UTF_8);
    }
}

