package io.github.rwintgen.avaj_launcher.aircrafts;

import io.github.rwintgen.avaj_launcher.buildings.WeatherTower;
import io.github.rwintgen.avaj_launcher.exceptions.ALSimulationException;
import io.github.rwintgen.avaj_launcher.utils.Coordinates;

abstract class Aircraft implements Flyable {

    protected final long id;
    protected final String name;
    protected String type;
    protected String fullId;
    protected Coordinates coordinates;
    protected WeatherTower weatherTower;

    public abstract void updateConditions() throws ALSimulationException;

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

    public void registerTower(WeatherTower p_tower) throws ALSimulationException{
        if (p_tower == null) {
            throw new ALSimulationException("No weather tower found");
        }

        weatherTower = p_tower;
        p_tower.register(this);
    }

    protected void changeCoords(String direction, int amount) {
        int lon = coordinates.getLongitude();
        int lat = coordinates.getLatitude();
        int h = coordinates.getHeight();

        switch (direction) {
            case "longitude":
                lon += amount;
                if (lon < 0) lon = 0;
                break;
            case "latitude":
                lat += amount;
                if (lat < 0) lat = 0;
                break;
            case "height":
                h += amount;
                if (h < 0) h = 0;
                if (h > 100) h = 100;
                break;
            default:
                throw new IllegalArgumentException("Unknown coordinates value: '" + direction + "'.");
        }

        coordinates = new Coordinates(lon, lat, h);
    }
}