package de.bhtb.external.data.files;

import java.io.*;


public class LinesIOPlayground {
    public static void main(String... args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/sonne.txt"));
             PrintWriter writer = new PrintWriter(new FileWriter("src/main/resources/lines.txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {

                writer.write(line);
                writer.write(Character.LINE_SEPARATOR);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
