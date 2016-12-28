/**
 * Copyright © 2014, Oracle and/or its affiliates. All rights reserved.
 * <p>
 * JDK 8 MOOC Lesson 3 homework
 */
package de.bhtb.functional;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Class to generate a list of random words
 *
 * @author Simon Ritter (@speakjava)
 */
public class RandomWords {
    private final List<String> sourceWords;
    private static final String WORD_REGEXP = "[- .:,]+";

    /**
     * Constructor
     * /Users/visenger/IdeaProjects/LEHRE/src/main/resources/words
     *
     * @throws IOException If the source words file cannot be read
     */
    public RandomWords() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("src/main/resources/words"))) {
            sourceWords = reader.lines()
                    .flatMap(s -> Stream.of(s.split(WORD_REGEXP)))
                    .collect(Collectors.toList());

            System.out.println("Loaded " + sourceWords.size() + " words");
        }
    }

    /**
     * Create a list of a given size containing random words
     *
     * @param listSize The size of the list to create
     * @return The created list
     */
    public List<String> createList(int listSize) {
        Random rand = new Random();
        List<String> wordList = rand.ints(listSize, 0, sourceWords.size())
                .mapToObj(i -> sourceWords.get(i))
                .collect(Collectors.toList());
        return wordList;
    }

    /**
     * Return the list of all source words, which cannot be modified
     *
     * @return The unmodifiable list of all source words
     */
    public List<String> allWords() {
        return Collections.unmodifiableList(sourceWords);
    }
}