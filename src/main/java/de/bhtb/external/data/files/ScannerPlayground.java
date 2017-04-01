package de.bhtb.external.data.files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ScannerPlayground {
    public static void main(String... args) {

        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("src/main/resources/sonne.txt")))) {

            while (scanner.hasNextLine()) {
                String nextToken = scanner.nextLine();
                System.out.println(nextToken);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
