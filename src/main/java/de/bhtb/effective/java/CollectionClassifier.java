package de.bhtb.effective.java;

import java.math.BigInteger;
import java.util.*;

/**
 * Item 41: Use overloading judiciously.
 */
public class CollectionClassifier {

    public static String classify(Set<?> coll) {
        return "SET";
    }

    public static String classify(List<?> coll) {
        return "LIST";
    }

    public static String classify(Collection<?> coll) {
        return coll instanceof Set ? "SET" : coll instanceof List ? "LIST" : "UNKNOWN COLLECTION";
    }

    public static void main(String... args) {
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values()
        };

        for (Collection<?> c : collections) {
            System.out.println(classify(c));
        }


    }
}
