package de.bhtb.collections;

import java.util.Arrays;


public class MeineArrayListe<E> {
    private E[] list;
    private int size;
    private int capacity;
    private int increment;

    // with initial capacity c
    public MeineArrayListe(int c, int inc) {
        capacity = c;
        list = (E[]) new Object[c];
        size = 0;
        increment = inc;
    }

    // for all methods check/implement the border cases.
    public void addElement(int i, E element) {
        list[i] = element;
    }

    public E[] deleteElement(int i) {
        E[] newArray = null;
        if (i >= capacity) {
            System.err.println("out of array range");
        } else {
            E[] firstPart = Arrays.copyOfRange(list, 0, i);
            E[] secondPart = Arrays.copyOfRange(list, i + 1, list.length);


            int firstLength = firstPart.length;
            int secondLength = secondPart.length;
            newArray = (E[]) new Object[firstLength + secondLength];

            System.arraycopy(firstPart, 0, newArray, 0, firstLength);
            System.arraycopy(secondPart, 0, newArray, firstLength, secondLength);
        }
        list = newArray;
        return list;
    }

    public static void main(String... args) {
        MeineArrayListe<String> meineArrayListe = new MeineArrayListe<String>(4, 1);
        meineArrayListe.addElement(0, "1");
        meineArrayListe.addElement(1, "2");
        meineArrayListe.addElement(2, "3");
        meineArrayListe.addElement(3, "4");
        meineArrayListe.deleteElement(1);
        System.out.println("meine Array List = " + meineArrayListe);
    }
}
