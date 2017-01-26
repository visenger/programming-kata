package de.bhtb.exception.handling;

import java.util.List;

/**
 * Created by visenger on 17/12/16.
 */
public class CoffeeMaker {
    private int kg;

    public CoffeeMaker(int coffeeKg) {
        if (coffeeKg < 0) throw new IllegalArgumentException("the amount should be positive number");
        this.kg = coffeeKg;
    }

    public boolean isCoffeeAvailable(List<String> coffeeRoastings) throws NoCoffeeException {
        boolean available = false;
        if (coffeeRoastings.isEmpty())
            throw new NoCoffeeException("you shall order more coffee");
        else available = true;
        return available;
    }
}
