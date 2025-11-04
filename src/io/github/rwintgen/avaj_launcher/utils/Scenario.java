package io.github.rwintgen.avaj_launcher.utils;

import java.util.List;

public final class Scenario {
    private final int runs;
    private final List<AircraftSpecs> aircraftsSpecs;

    public Scenario(int p_runs, List<AircraftSpecs> p_aircraftsSpecs) {
        if (runs < 1) {
            throw new IllegalArgumentException("invalid parameter: \'" + runs + "\' must be a positive integer.");
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

            if (!p_type.equals("baloon") && !p_type.equals("helicopter") && !p_type.equals("jetplane")) {
                throw new IllegalArgumentException("invalid Aircraft type: \'" + p_type + "\' must be one of Baloon, Helicopter or Jetplane.");
            }

            type = p_type;
            name = p_name;
            coords = p_coords;
        }
    }

    public startSimulation() {
        WeatherTower weatherTower = new WeatherTower();

        for (AircraftSpec a : aircraftsSpecs) {
            Aircraft aircraft = AircraftFactory.getInstance().newAircraft(a.type, a.name, a.coords);
            aircraft.registerTower(weatherTower);
            weatherTower.register(aircraft);
        }

        for (int i = 0 ; i < runs ; i++) {
            weatherTower.changeWeather();
        }
    }
}