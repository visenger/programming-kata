package de.my.playground;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.StandardOpenOption.CREATE;

public class FileReader {

    public static void main(String... args) {

        String inputFile = "src/main/resources/datei1702_vor.html";
        String outputFile = "src/main/resources/datei1702_after.html";

        try (Stream<String> lines = Files.lines(Paths.get(inputFile));
             BufferedWriter writer = Files
                     .newBufferedWriter(Paths.get(outputFile), StandardCharsets.UTF_8, CREATE)) {

            List<String> changedLines = lines.map(s -> {
                String changed = s
                        .replace("ä", "&auml;")
                        .replace("Ä", "&Auml;")
                        .replace("ü", "&uuml;")
                        .replace("Ü", "&Uuml;")
                        .replace("ö", "&ouml;")
                        .replace("Ö", "&Ouml;")
                        .replace("ß", "&szlig;");
                //System.out.println(changed);

                return changed;

            }).collect(Collectors.toList());


            Files.write(Paths.get(outputFile), changedLines, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
