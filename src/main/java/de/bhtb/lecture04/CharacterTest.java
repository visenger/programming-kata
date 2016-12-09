package de.bhtb.lecture04;

/**
 * Created by visenger on 31/10/16.
 */
public class CharacterTest {
    public static void main(String[] args) {
        char a = '\u004D';
        char b = '\u0040';
        char c = 'A';
        int d = 0;
        d = c + 4;
        System.out.println("Das Ergebnis ist " + a + " .");
        System.out.println("Das Ergebnis ist " + b + " .");
        System.out.println("Das Ergebnis ist " + ++c + " .");
        System.out.println("Das Ergebnis ist " + d + " .");
    }
}