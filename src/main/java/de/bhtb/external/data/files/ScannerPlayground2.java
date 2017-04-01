package de.bhtb.external.data.files;

import java.util.Scanner;

public class ScannerPlayground2 {

    public static void main(String... args) {

        System.out.println("Please, tell me your name");

        Scanner stdInput = new Scanner(System.in);

        System.out.printf("Your name is: %s", stdInput.nextLine());
    }
}
