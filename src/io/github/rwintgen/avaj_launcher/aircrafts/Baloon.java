package io.github.rwintgen.avaj_launcher.aircrafts;

import io.github.rwintgen.avaj_launcher.aircrafts.Baloon;
import io.github.rwintgen.avaj_launcher.exceptions.ALSimulationException;
import io.github.rwintgen.avaj_launcher.utils.Coordinates;
import java.util.Hashtable;
import java.util.Dictionary;

public class Baloon extends Aircraft {

    Dictionary<String, String> broadcasts = new Hashtable<>();

    public Baloon(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
        type = "baloon";

        broadcasts.put("rain", "Rain (Baloon)");
        broadcasts.put("fog", "Fog (Baloon)");
        broadcasts.put("sun", "Sun (Baloon)");
        broadcasts.put("snow", "Snow (Baloon)");
    }

    public void updateConditions() throws ALSimulationException {
        String weather = weatherTower.getWeather(coordinates);

        switch (weather) {
            case "rain":
                changeCoords("height", -5);
            case "fog":
                changeCoords("height", -3);
            case "sun":
                changeCoords("longitude", 2);
                changeCoords("height", 4);
            case "snow":
                changeCoords("height", -15);
            default:
                throw new ALSimulationException("Unknown climate conditions: \'" + weather + "\'.");
        }
    }
}