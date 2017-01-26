package de.bhtb.functional;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by visenger on 01/01/17.
 */
public class FunctionalPlayground {

    public static void main(String... args) {

        Function<Integer, Integer> f = x -> x < 0 ? (-1) * x : x;
        int abc = calculate(f, -2);
        System.out.println("int abc = " + abc);

        Function<Integer, Double> f2 = x -> Math.sqrt(x);
        double sqrt = calculate(f2, 36);
        System.out.println("double sqrt = " + sqrt);


        int sumNums = Arrays.asList(2, 6, 2, 5, 8, 1)
                .parallelStream()
                .mapToInt(i -> i)
                .sum();


        List<Integer> numbers = Arrays.asList(2, 6, 2, 5, 8, 1);
        int count = 0;
        for (int i : numbers) {
            if (i % 2 == 0)
                count += 1;
        }

        long countStreams = Stream.of(2, 6, 2, 5, 8, 1)
                .filter(x -> x % 2 == 0)
                .count();


        int[] arr = new int[1000];
        Arrays.parallelSetAll(arr, value -> value);

        int sum = Arrays.stream(arr)
                .parallel()
                .map(operand -> operand * operand)
                //.peek(value -> System.out.println("val = " + value))
                .sum();
        System.out.println("sum = " + sum);


        UnaryOperator<Integer> inc = x -> x + 1;
        Supplier<StringBuilder> strSuppl = () -> new StringBuilder();
        Consumer<String> str = s -> System.out.println("Hello Lambda" + s);
        Function<Integer, Double> multiply = (x) -> Math.sqrt(x);
        Comparator<String> comparator = (s1, s2) -> s1.compareTo(s2);


        List<String> words = Arrays.asList("Lambda", "Snow", "Awesome", "Apple", "Green")
                .stream()
                .map(s -> s.toLowerCase())
                .distinct()
                .filter(s -> s.startsWith("a"))
                .collect(Collectors.toList());

        words.forEach(System.out::println);


    }


    public static <T, R> R calculate(Function<T, R> f, T n) {
        return f.apply(n);
    }
}
