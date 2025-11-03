package io.github.rwintgen.avaj_launcher.utils;

import java.util.List;

public final class Scenario {
    private final int runs;
    private final List<AircraftSpecs> aircraftSpecs;

    public Scenario(int runs, List<AircraftSpecs> aircraftSpecs) {
        if (runs < 1) {
            throw new IllegalArgumentException("invalid parameter: \'" + runs + "\' must be a positive integer.");
        }

        this.runs = runs;
        this.aircraftSpecs = aircraftSpecs;
    }

    static final class AircraftSpecs {
        final String type;
        final String name;
        final Coordinates coords;

        AircraftSpecs (String p_type, String p_name, Coordinates p_coords) {
            type = type.toLowerCase();
            name = name.toLowerCase();

            if (!p_type.equals("baloon") && !p_type.equals("helicopter") && !p_type.equals("jetplane")) {
                throw new IllegalArgumentException("invalid Aircraft type: \'" + p_type + "\' must be one of Baloon, Helicopter or Jetplane.");
            }

            type = p_type;
            name = p_name;
            coords = p_coords;
        }
    }
}