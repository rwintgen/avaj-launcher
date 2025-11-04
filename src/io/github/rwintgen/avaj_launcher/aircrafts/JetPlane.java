package io.github.rwintgen.avaj_launcher.aircrafts;

import io.github.rwintgen.avaj_launcher.exceptions.ALSimulationException;
import java.util.Dictionary;

public class JetPlane extends Aircraft {

    Dictionary<String, String> broadcasts = new Hashtable<>();

    public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_name, p_coordinates);
        type = "jetplane";

        broadcasts.put("rain", "Rain (JetPlane)");
        broadcasts.put("fog", "Fog (JetPlane)");
        broadcasts.put("sun", "Sun (JetPlane)");
        broadcasts.put("snow", "Snow (JetPlane)");
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);

        switch (weather) {
            case rain:
                changeCoords("latitude", 5);
            case fog:
                changeCoords("latitude", 1);
            case sun:
                changeCoords("latitude", 10);
                changeCoords("height", 2);
            case snow:
                changeCoords("height", -7);
            default:
                throw new ALSimulationException("Unknown climate conditions: \'" + weather + "\'.");
        }
    }
}