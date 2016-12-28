package de.bhtb.functional;

import java.util.Optional;

/**
 * Created by visenger on 27/12/16.
 */
public class Position {

    public Optional<Latitude> getLatitude() {
        return Optional.of(new Latitude());
    }
}
