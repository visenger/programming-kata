package de.bhtb.functional;

/**
 * Copyright © 2016, Oracle and/or its affiliates. All rights reserved.
 * <p>
 * JDK 8 MOOC Lesson 2 homework
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Speakjava (Simon Ritter)
 */
public class Lesson2 {
    private static final String WORD_REGEXP = "[- .:,]+";

    /**
     * Run the exercises to ensure we got the right answers
     *
     * @throws java.io.IOException
     */
    public void runExercises() throws IOException {
        System.out.println("JDK 8 Lambdas and Streams MOOC Lesson 2");
        System.out.println("Running exercise 1 solution...");
        exercise1();
        System.out.println("Running exercise 2 solution...");
        exercise2();
        System.out.println("Running exercise 3 solution...");
        exercise3();
        System.out.println("Running exercise 4 solution...");
        exercise4();
        System.out.println("Running exercise 5 solution...");
        exercise5();
        System.out.println("Running exercise 6 solution...");
        exercise6();
        System.out.println("Running exercise 7 solution...");
        exercise7();
    }

    /**
     * Exercise 1
     * <p>
     * Create a new list with all the strings from original list converted to
     * lower case and print them out.
     */
    private void exercise1() {
        List<String> list = Arrays.asList(
                "The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

    /* YOUR CODE HERE */

        list.stream()
                .map(String::toLowerCase)
                .forEach(System.out::println);
    }

    /**
     * Exercise 2
     * <p>
     * Modify exercise 1 so that the new list only contains strings that have an
     * odd length
     */
    private void exercise2() {
        List<String> list = Arrays.asList(
                "The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

    /* YOUR CODE HERE */
        list.stream()
                .filter(s -> s.length() % 2 != 0)
                .map(String::toLowerCase)
                .forEach(System.out::println);
    }

    /**
     * Exercise 3
     * <p>
     * Join the second, third and forth strings of the list into a single string,
     * where each word is separated by a hyphen (-). Print the resulting string.
     */
    private void exercise3() {
        List<String> list = Arrays.asList(
                "The", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");

    /* YOUR CODE HERE */
        String str = list.stream()
                .skip(1)
                .limit(3)
                .collect(Collectors.joining("-"));
        System.out.println("string = " + str);
    }

    /**
     * Count the number of lines in the file using the BufferedReader provided
     * /Users/visenger/IdeaProjects/LEHRE/src/main/resources/Sonne.txt
     */
    private void exercise4() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get("src/main/resources/test.txt"), StandardCharsets.UTF_8)) {
      /* YOUR CODE HERE */
            long count = reader.lines().count();
            System.out.println("lines count = " + count);
        }
    }

    /**
     * Using the BufferedReader to access the file, create a list of words with
     * no duplicates contained in the file.  Print the words.
     * <p>
     * HINT: A regular expression, WORD_REGEXP, is already defined for your use.
     */
    private void exercise5() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get("src/main/resources/test.txt"), StandardCharsets.UTF_8)) {
      /* YOUR CODE HERE */
            reader.lines()
                    .flatMap(s -> Stream.of(s.split(WORD_REGEXP)))
                    .distinct()
                    .forEach(System.out::println);
        }
    }

    /**
     * Using the BufferedReader to access the file create a list of words from
     * the file, converted to lower-case and with duplicates removed, which is
     * sorted by natural order.  Print the contents of the list.
     */
    private void exercise6() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get("src/main/resources/test.txt"), StandardCharsets.UTF_8)) {
      /* YOUR CODE HERE */
            reader.lines()
                    .flatMap(s -> Stream.of(s.split(WORD_REGEXP)))
                    .map(String::toLowerCase)
                    .distinct()
                    .sorted() /* using natural sorting */
                    .forEach(System.out::println);
        }
    }

    /**
     * Modify exercise6 so that the words are sorted by length:
     * Using the BufferedReader to access the file create a list of words from
     * the file, converted to lower-case and with duplicates removed, which is
     * sorted by length.  Print the contents of the list.
     */
    private void exercise7() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get("src/main/resources/test.txt"), StandardCharsets.UTF_8)) {
      /* YOUR CODE HERE */
            reader.lines()
                    .flatMap(s -> Stream.of(s.split(WORD_REGEXP)))
                    .map(String::toLowerCase)
                    .distinct()
                    .sorted((o1, o2) -> o1.length() - o2.length())
                    .forEach(System.out::println);

        }
    }

    /**
     * Main entry point for application
     *
     * @param args the command line arguments
     * @throws IOException If file access does not work
     */
    public static void main(String[] args) throws IOException {
        Lesson2 lesson = new Lesson2();
        lesson.runExercises();
    }
}

