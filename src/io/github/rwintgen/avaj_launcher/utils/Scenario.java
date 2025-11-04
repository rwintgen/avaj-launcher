package io.github.rwintgen.avaj_launcher.utils;

import io.github.rwintgen.avaj_launcher.buildings.WeatherTower;
import io.github.rwintgen.avaj_launcher.buildings.AircraftFactory;
import io.github.rwintgen.avaj_launcher.aircrafts.Flyable;
import io.github.rwintgen.avaj_launcher.utils.Coordinates;
import java.util.ArrayList;
import java.util.List;

public final class Scenario {
    private final int runs;
    private final List<AircraftSpecs> aircraftsSpecs;

    public Scenario(int p_runs, List<AircraftSpecs> p_aircraftsSpecs) {
        if (p_runs < 1) {
            throw new IllegalArgumentException("invalid parameter: \'" + p_runs + "\' must be a positive integer.");
        }
        if (p_aircraftsSpecs == null) {
            throw new IllegalArgumentException("invalid aircraftSpecs found.");
        }

        runs = p_runs;
        aircraftsSpecs = p_aircraftsSpecs;
    }

    static final class AircraftSpecs {
        final String type;
        final String name;
        final Coordinates coords;

        AircraftSpecs (String p_type, String p_name, Coordinates p_coords) {
            p_type = p_type.toLowerCase();
            p_name = p_name.toLowerCase();

            if (!p_type.equalsIgnoreCase("baloon") && !p_type.equalsIgnoreCase("helicopter") && !p_type.equalsIgnoreCase("jetplane")) {
                throw new IllegalArgumentException("invalid Aircraft type: \'" + p_type + "\' must be one of Baloon, Helicopter or Jetplane.");
            }

            type = p_type.toLowerCase();
            name = p_name.toLowerCase();
            coords = p_coords;
        }
    }

    public void startSimulation() {
        WeatherTower weatherTower = new WeatherTower();
        List<Flyable> aircrafts = new ArrayList<>();

        // open output file

        for (AircraftSpecs as : aircraftsSpecs) {
            FLyable aircraft = AircraftFactory.getInstance().newAircraft(type, name, coords);
            aircraft.registerTower(weatherTower);
            aircrafts.add(aircraft);
        }

        for (int i = 0 ; i < runs ; i++) {
            for (Flyable a : aircrafts) {
                // Log status
            }
            weatherTower.changeWeather();
        }

        // close output file
    }
}