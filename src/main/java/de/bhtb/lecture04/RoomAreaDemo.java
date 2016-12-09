package de.bhtb.lecture04;

import java.util.Scanner;

/**
 * Created by visenger on 31/10/16.
 */
public class RoomAreaDemo {
    public static final double CONVERSION_FACTOR = 0.09290304;

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the length of the room in feet? ");

        double length = scanner.nextDouble();

        System.out.println("What is the width of the room in feet? ");

        double width = scanner.nextDouble();

        double squareFeet = length * width;
        double squareMeters = squareFeet * CONVERSION_FACTOR;

        System.out.println("The area is  ");
        System.out.println(squareFeet + " square feet; ");
        System.out.println(squareMeters + " square meters ");

        scanner.close();
    }
}
