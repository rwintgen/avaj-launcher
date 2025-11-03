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

        AircraftSpecs (String type, String name, Coordinates coords) {
            type = type.toLowerCase();
            name = name.toLowerCase();

            if (!type.equals("baloon") && !type.equals("helicopter") && !type.equals("jetplane")) {
                throw new IllegalArgumentException("invalid Aircraft type: \'" + type + "\' must be one of Baloon, Helicopter or Jetplane.");
            }

            this.type = type;
            this.name = name;
            this.coords = coords;
        }
    }
}