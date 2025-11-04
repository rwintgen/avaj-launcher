package io.github.rwintgen.avaj_launcher.aircrafts;

import io.github.rwintgen.avaj_launcher.exceptions.ALSimulationException;
import io.github.rwintgen.avaj_launcher.utils.Coordinates;
import io.github.rwintgen.avaj_launcher.utils.Writer;
import java.util.Dictionary;
import java.util.Hashtable;

public class JetPlane extends Aircraft {

    Dictionary<String, String> broadcasts = new Hashtable<>();

    public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
        type = "JetPlane";
        fullId = type + "#" + name + "(" + id + ")";

        broadcasts.put("rain", "Rain (JetPlane)");
        broadcasts.put("fog", "Fog (JetPlane)");
        broadcasts.put("sun", "Sun (JetPlane)");
        broadcasts.put("snow", "Snow (JetPlane)");
    }

    public String getFullId() {
        return (fullId);
    }

    public void updateConditions() throws ALSimulationException {
        String weather = weatherTower.getWeather(coordinates);

        switch (weather) {
            case "rain":
                changeCoords("latitude", 5);
                break;
            case "fog":
                changeCoords("latitude", 1);
                break;
            case "sun":
                changeCoords("latitude", 10);
                changeCoords("height", 2);
                break;
            case "snow":
                changeCoords("height", -7);
                break;
            default:
                throw new ALSimulationException("Unknown climate conditions: \'" + weather + "\'.");
        }

        Writer.getInstance().write(getFullId() + ": " + broadcasts.get(weather));
    }
}