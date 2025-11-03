package io.github.rwintgen.avaj_launcher.buildings;

public class AircraftFactory {

    private static AircraftFactory instance;
    private static final long id = 0;

    private AircraftFactory() {
    }

    public static AircraftFactory getInstance() {
        if (instance == null) {
            instance = new AircraftFactory();
        }
        return (instance);
    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
        p_type = p_type.toLowerCase();

        switch(p_type) {
            case baloon:
                return new Baloon(id++, p_name, p_coordinates);
            case helicopter:
                return new Helicopter(id++, p_name, p_coordinates);
            case jetplane:
                return new JetPlane(id++, p_name, p_coordinates);
            default:
                throw new ALSimulationException("Unkown aircraft type detected");
        }
    }
}