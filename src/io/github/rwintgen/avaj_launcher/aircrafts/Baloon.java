package io.github.rwintgen.avaj_launcher.aircrafts;

import io.github.rwintgen.avaj_launcher.exceptions.ALSimulationException;
import java.util.Dictionary;

public class Baloon extends Aircraft {

    Dictionary<String, String> broadcasts = new Hashtable<>;

    public Baloon(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_name, p_coordinates);
        type = "baloon";

        boradcasts.put("rain", "Rain (Baloon)");
        boradcasts.put("fog", "Fog (Baloon)");
        boradcasts.put("sun", "Sun (Baloon)");
        boradcasts.put("snow", "Snow (Baloon)");
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);

        switch (weather) {
            case rain:
                changeCoords("height", -5);
            case fog:
                changeCoords("height", -3);
            case sun:
                changeCoords("longitude", 2);
                changeCoords("height", 4);
            case snow:
                changeCoords("height", -15);
            default:
                throw new ALSimulationException("Unknown climate conditions: \'" + weather + "\'.");
        }
    }
}