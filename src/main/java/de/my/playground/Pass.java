package de.my.playground;

/**
 * Java is pass-by-value.
 * */
public class Pass {
    public static void main(String[] args) {
        Dog d = new Dog("Max");
        System.out.println("Before:" + d.getName());
        display(d);
        System.out.println("After:" + d.getName());
    }

    public static void display(Dog d) {
        d.setName("Fifi1");

        d = new Dog("Fifi2");
        d.setName("Fifi3");
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
        return String.format("Dog{ name = %s }", name);
    }
}
