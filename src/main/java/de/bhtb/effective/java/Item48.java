package de.bhtb.effective.java;

import java.math.BigDecimal;

/**
 * Item 48: Avoid float and double if exact answer is required;
 */
public class Item48 {

    public static void main(String... args) {

        BigDecimal amount = new BigDecimal("1.03");
        BigDecimal price = new BigDecimal(".42");
        amount = amount.subtract(price);
        System.out.println("Result = " + amount);

    }
}
