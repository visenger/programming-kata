package de.bhtb.lecture01;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by visenger on 30/10/16.
 */
public class AverageScore {

    public static void main(String... args) {
        double value = BigDecimal.
                valueOf(2.34234).
                setScale(2, RoundingMode.HALF_EVEN).
                doubleValue();
        System.out.println("value = " + value);
    }
}
