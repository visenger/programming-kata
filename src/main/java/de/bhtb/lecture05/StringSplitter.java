package de.bhtb.lecture05;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * String:split() Method demonstrator
 */
public class StringSplitter {

    public static void main(String... args) {
        String questionAndAnswer = "what is blue + yellow / green";
        String[] qa = questionAndAnswer.split("/");
        for (String element : qa) {
            System.out.println("element = " + element);
        }


        File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.isHidden();
            }
        });


        File[] hiddenFiles2 = new File(".").listFiles(File::isHidden);

        File[] hiddenFiles3 = new File(".").listFiles(a -> a.isHidden());


        Comparator<Dog> dogComparator = (Dog dog1, Dog dog2) -> dog1.getName().compareTo(dog2.getName());

        List<Dog> doggi = new ArrayList();
        doggi.add(new Dog("Affi"));
        doggi.add(new Dog("Fluffi"));
        doggi.add(new Dog("Baffi"));

//        doggi.sort(new Comparator<Dog>() {
//            @Override
//            public int compare(Dog dog1, Dog dog2) {
//                return dog1.getName().compareTo(dog2.getName());
//            }
//        });

        doggi.forEach(System.out::println);

        List<Dog> sortedDogs = doggi.stream().sorted(dogComparator).collect(Collectors.toList());

        sortedDogs.forEach(System.out::println);


        List<String> strings = Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());

        StringJoiner sj = new StringJoiner(":", "[", "]");
        sj.add("George").add("Sally").add("Fred");
        String desiredString = sj.toString();
        System.out.println("joined string = " + desiredString);


    }

}

class Dog {
    String name;

    public Dog(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Dog{ %s }", name);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        Dog otherDog = (Dog) other;

        return getName().equals(otherDog.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}

