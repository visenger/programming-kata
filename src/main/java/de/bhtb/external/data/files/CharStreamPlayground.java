package de.bhtb.external.data.files;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class CharStreamPlayground {

    public static void main(String... args) {
        try (FileReader fr = new FileReader("src/main/resources/sonne.txt");
             FileWriter fw = new FileWriter("src/main/resources/tmp.txt")) {
            int c;

            while ((c = fr.read()) != -1) {
                fw.write(c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
