package de.bhtb.exception.handling;

import java.util.List;

/**
 * Created by visenger on 17/12/16.
 */
public class CoffeeMaker {

    public boolean isCoffeeAvailable(List<String> coffeeRoastings) throws NoCoffeeException {
        boolean available = false;
        if (coffeeRoastings.isEmpty())
            throw new NoCoffeeException("you shall order more coffee");
        else available = true;
        return available;
    }
}
