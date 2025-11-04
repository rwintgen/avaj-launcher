package io.github.rwintgen.avaj_launcher.aircrafts;

import io.github.rwintgen.avaj_launcher.exceptions.ALSimulationException;
import io.github.rwintgen.avaj_launcher.utils.Coordinates;
import java.util.Dictionary;
import java.util.Hashtable;

public class Helicopter extends Aircraft {

    Dictionary<String, String> broadcasts = new Hashtable<>();

    public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
        type = "Helicopter";
        fullId = type + "#" + name + "(" + id + ")";

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
                break;
            case "fog":
                changeCoords("longitude", 1);
                break;
            case "sun":
                changeCoords("longitude", 10);
                changeCoords("height", 2);
                break;
            case "snow":
                changeCoords("height", -12);
                break;
            default:
                throw new ALSimulationException("Unknown climate conditions: \'" + weather + "\'.");
        }
    }
}