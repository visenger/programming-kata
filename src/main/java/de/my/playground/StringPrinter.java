package de.my.playground;

/**
 * Created by visenger on 24/11/16.
 */
public class StringPrinter {
    public static void main(String... args) {
        Dog dog = new Dog("Fifi");

        System.out.println("dog = " + dog.toString());
    }
}
