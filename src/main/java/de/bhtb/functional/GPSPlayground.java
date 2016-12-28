package de.bhtb.functional;

import java.util.Optional;

/**
 * Created by visenger on 27/12/16.
 */
public class GPSPlayground {
    public static void main(String... args) {
        GPSData gpsData = null;
        String direction = Optional.ofNullable(gpsData)
                .flatMap(GPSData::getPosition)
                .flatMap(Position::getLatitude)
                .flatMap(Latitude::getDirection)
                .orElse("NONE");
        System.out.println("direction is: " + direction);
    }
}
