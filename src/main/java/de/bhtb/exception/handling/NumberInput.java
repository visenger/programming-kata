package de.bhtb.exception.handling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * Created by visenger on 17/12/16.
 */
public class NumberInput {

    public static void main(String... args) {


        int number = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {

            try {
                number = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("this was not a number  " + scanner.next());
            }
        }

        System.out.println("thank you for a number = " + number);
    }

    public static void cat(File file) {
        RandomAccessFile input = null;
        String line = null;

        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            return;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
