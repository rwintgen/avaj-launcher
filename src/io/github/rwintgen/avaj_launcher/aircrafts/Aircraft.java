package io.github.rwintgen.avaj_launcher.aircrafts;

import io.github.rwintgen.avaj_launcher.utils.Coordinates;
import io.github.rwintgen.avaj_launcher.buildings.WeatherTower;

abstract class Aircraft implements Flyable {

    protected final long id;
    protected final String name;
    protected Coordinates coordinates;

    abstract void updateConditions() {
    }

    abstract void registerTower(WeatherTower p_tower) {
    }

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
        if (p_id < 0) {
            throw new IllegalArgumentException("Aircraft id must be a positive integer (current: " + p_id + ").");
        }
        if (p_name == null || p_name.empty()) {
            throw new IllegalArgumentException("Aircraft name cannot be empty.");
        }

        id = p_id;
        name = p_name;
        coordinates = p_coordinates;
    }
}