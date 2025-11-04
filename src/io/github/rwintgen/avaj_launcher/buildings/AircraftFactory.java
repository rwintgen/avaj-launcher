package io.github.rwintgen.avaj_launcher.buildings;

import io.github.rwintgen.avaj_launcher.aircrafts.Baloon;
import io.github.rwintgen.avaj_launcher.aircrafts.Helicopter;
import io.github.rwintgen.avaj_launcher.aircrafts.Flyable;
import io.github.rwintgen.avaj_launcher.aircrafts.JetPlane;
import io.github.rwintgen.avaj_launcher.exceptions.ALSimulationException;
import io.github.rwintgen.avaj_launcher.utils.Coordinates;

public class AircraftFactory {

    private static AircraftFactory instance;
    private static long id = 0;

    private AircraftFactory() {
    }

    public static AircraftFactory getInstance() {
        if (instance == null) {
            instance = new AircraftFactory();
        }
        return (instance);
    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) throws ALSimulationException {
        p_type = p_type.toLowerCase();

        switch(p_type) {
            case "baloon":
                return new Baloon(id++, p_name, p_coordinates);
            case "helicopter":
                return new Helicopter(id++, p_name, p_coordinates);
            case "jetplane":
                return new JetPlane(id++, p_name, p_coordinates);
            default:
                throw new ALSimulationException("Unknown aircraft type detected");
        }
    }
}