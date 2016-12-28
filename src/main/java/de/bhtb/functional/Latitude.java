package de.bhtb.functional;

import java.util.Optional;

/**
 * Created by visenger on 27/12/16.
 */
public class Latitude {
    String s = "here is the ultimate direction";

    public Optional<String> getDirection() {
        return Optional.ofNullable(s);
    }
}
