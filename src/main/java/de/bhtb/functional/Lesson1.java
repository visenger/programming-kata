package de.bhtb.functional;

import de.bhtb.lecture05.StringSplitter;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Lesson1 {
    /**
     * Run the exercises to ensure we got the right answers
     */
    public void runExercises() {
        System.out.println("JDK 8 Lambdas and Streams MOOC Lesson 1");
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
    }

    /**
     * All exercises should be completed using Lambda expressions and the new
     * methods added to JDK 8 where appropriate. There is no need to use an
     * explicit loop in any of the code. Use method references rather than full
     * lambda expressions wherever possible.
     */
    /**
     * Exercise 1
     * <p>
     * Create a string that consists of the first letter of each word in the list
     * of Strings provided.
     */
    private void exercise1() {
        List<String> list = Arrays.asList(
                "alpha", "bravo", "charlie", "delta", "echo", "foxtrot");
        StringBuilder b = new StringBuilder();
    /* YOUR CODE HERE */
        list.stream().map(s -> String.valueOf(s.charAt(0))).forEach(c -> b.append(c));
        System.out.println("first letters = " + b.toString());

        Optional<String> reduce = list.stream().map(s -> String.valueOf(s.charAt(0))).reduce(String::concat);
        System.out.println("reduce = " + reduce.get());
    }

    /**
     * Exercise 2
     * <p>
     * Remove the words that have odd lengths from the list.
     */
    private void exercise2() {
        List<String> list = new ArrayList<>(Arrays.asList(
                "alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));

    /* YOUR CODE HERE */
        List<String> evenWords = list.stream().filter(s -> (s.length() % 2) == 0).collect(Collectors.toList());
        evenWords.forEach(System.out::println);
    }

    /**
     * Exercise 3
     * <p>
     * Replace every word in the list with its upper case equivalent.
     */
    private void exercise3() {
        List<String> list = new ArrayList<>(Arrays.asList(
                "alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));

    /* YOUR CODE HERE */
        List<String> toUpperCase = list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        toUpperCase.forEach(System.out::println);
    }

    /**
     * Exercise 4
     * <p>
     * Convert every key-value pair of the map into a string and append them all
     * into a single string, in iteration order.
     */
    private void exercise4() {
        Map<String, Integer> map = new TreeMap<>();
        map.put("c", 3);
        map.put("b", 2);
        map.put("a", 1);

    /* YOUR CODE HERE */
        String collect = map.entrySet().stream()
                .map(e -> (e.getKey() + "->" + e.getValue()).toString())
                .collect(Collectors.joining(":"));
        System.out.println("collect = " + collect);
    }

    /**
     * Exercise 5
     * <p>
     * Create a new thread that prints the numbers from the list.
     */
    private void exercise5() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    /* YOUR CODE HERE */
        Runnable execForThread = () -> list.forEach(System.out::println);
        new Thread(execForThread).start();
    }

    /**
     * Main entry point for application
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lesson1 lesson = new Lesson1();
        lesson.runExercises();
    }
}

