package de.bhtb.external.data.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by visenger on 31/03/17.
 */
public class FilesPlayground {

    public static void main(String... args) {
        String text = "Some text to test Java Files I/O";
        Path path = Paths.get("/Users/visenger/IdeaProjects/LEHRE/src/main/resources/test.txt");

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(text);

        } catch (IOException e) {
            System.err.format("%s does not exist\n", path.getFileName());
        }

        Path path2 = Paths.get("/Users/visenger/IdeaProjects/LEHRE/src/main/resources/sonne.txt");
        try (BufferedReader reader = Files.newBufferedReader(path2)) {
            reader.lines().forEach(System.out::println);
        } catch (IOException e) {
            System.err.format("%s does not exist\n", path2.getFileName());
        }
    }
}
