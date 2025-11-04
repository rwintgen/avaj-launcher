package io.github.rwintgen.avaj_launcher.aircrafts;

import io.github.rwintgen.avaj_launcher.utils.Coordinates;
import io.github.rwintgen.avaj_launcher.buildings.WeatherTower;
import io.github.rwintgen.avaj_launcher.exceptions.ALSimulationException;

abstract class Aircraft implements Flyable {

    protected final long id;
    protected final String name;
    protected final String type;
    protected Coordinates coordinates;
    protected final WeatherTower weatherTower;

    public abstract void updateConditions();
    public abstract void registerTower(WeatherTower p_tower);

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
        if (p_id < 0) {
            throw new IllegalArgumentException("Aircraft id must be a positive integer (current: " + p_id + ").");
        }
        if (p_name == null || p_name.isEmpty()) {
            throw new IllegalArgumentException("Aircraft name cannot be empty.");
        }

        id = p_id;
        name = p_name;
        coordinates = p_coordinates;
    }

    protected changeCoords(String direction, int amount) {
        switch (p_direction) {
            case longitude:
                coordinates.longitude += amount;
                if (longitude < 1) {
                    longitude = 1;
                }
            case latitude:
                coordinates.latitude += amount;
                if (latitude < 1) {
                    latitude = 1;
                }
            case height:
                coordinates.height += amount;
                if (height < 0 || height > 100) {
                    height = height < 0 ? 0 : 100;
                }
            default:
                throw new ALSimulationException("Unknown coordinates value: \'" + direction + "\'.")
        }
    }
}