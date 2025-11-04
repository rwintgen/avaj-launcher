package io.github.rwintgen.avaj_launcher.aircrafts;

import io.github.rwintgen.avaj_launcher.exceptions.ALSimulationException;
import io.github.rwintgen.avaj_launcher.utils.Coordinates;
import java.util.Dictionary;
import java.util.Hashtable;

public class Helicopter extends Aircraft {

    Dictionary<String, String> broadcasts = new Hashtable<>();

    public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
        type = "helicopter";

        broadcasts.put("rain", "Rain (Helicopter)");
        broadcasts.put("fog", "Fog (Helicopter)");
        broadcasts.put("sun", "Sun (Helicopter)");
        broadcasts.put("snow", "Snow (Helicopter)");
    }

    public void updateConditions() throws ALSimulationException{
        String weather = weatherTower.getWeather(coordinates);

        switch (weather) {
            case "rain":
                changeCoords("longitude", 5);
            case "fog":
                changeCoords("longitude", 1);
            case "sun":
                changeCoords("longitude", 10);
                changeCoords("height", 2);
            case "snow":
                changeCoords("height", -12);
            default:
                throw new ALSimulationException("Unknown climate conditions: \'" + weather + "\'.");
        }
    }
}