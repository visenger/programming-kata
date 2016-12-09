package de.bhtb.lecture05.java8.exercise;

/**
 * Created by visenger on 09/12/16.
 */
public class Trader {
    private final String name;
    private final String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Traider{" +
                "name='" + this.name + '\'' +
                ", city='" + this.city + '\'' +
                '}';
    }
}
