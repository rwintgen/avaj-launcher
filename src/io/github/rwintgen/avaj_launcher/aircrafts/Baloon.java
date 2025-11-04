package io.github.rwintgen.avaj_launcher.aircrafts;

import io.github.rwintgen.avaj_launcher.exceptions.ALSimulationException;
import io.github.rwintgen.avaj_launcher.utils.Coordinates;
import io.github.rwintgen.avaj_launcher.utils.Writer;
import java.util.Hashtable;
import java.util.Dictionary;

public class Baloon extends Aircraft {

    private Dictionary<String, String> broadcasts = new Hashtable<>();

    public Baloon(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
        type = "Baloon";
        fullId = type + "#" + name + "(" + id + ")";

        broadcasts.put("rain", "Rain (Baloon)");
        broadcasts.put("fog", "Fog (Baloon)");
        broadcasts.put("sun", "Sun (Baloon)");
        broadcasts.put("snow", "Snow (Baloon)");
    }

    public String getFullId() {
        return (fullId);
    }

    public void updateConditions() throws ALSimulationException {
        String weather = weatherTower.getWeather(coordinates);

        switch (weather) {
            case "rain":
                changeCoords("height", -5);
                break;
            case "fog":
                changeCoords("height", -3);
                break;
            case "sun":
                changeCoords("longitude", 2);
                changeCoords("height", 4);
                break;
            case "snow":
                changeCoords("height", -15);
                break;
            default:
                throw new ALSimulationException("Unknown climate conditions: \'" + weather + "\'.");
        }

        if (coordinates.getHeight() <= 0) {
            return;
        }

        Writer.getInstance().write(getFullId() + ": " + broadcasts.get(weather));
    }
}