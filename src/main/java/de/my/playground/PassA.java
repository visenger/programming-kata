package de.my.playground;

/**
 * Created by visenger on 31/10/16.
 */
public class PassA {
    public static void main(String[] args) {
        int[] val = {125};
        System.out.println("Before: " + val[0]);
        change(val);
        System.out.println("After: " + val[0]);

        int i = 8;
        System.out.println("before changing  a number = " + i);
        changeNum(i);
        System.out.println("after changing a number = " + i);
    }

    public static void change(int[] value) {
        value[0] = 150;
        // value = new int[]{150};
    }

    public static void changeNum(int i) {
        i = i + 2;
    }
}
