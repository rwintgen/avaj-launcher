package io.github.rwintgen.avaj_launcher.aircrafts;

import io.github.rwintgen.avaj_launcher.exceptions.ALSimulationException;
import java.util.Dictionary;

public class JetPlane extends Aircraft {

    Dictionary<String, String> broadcasts = new Hashtable<>;

    public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_name, p_coordinates);
        type = "jetlane";

        boradcasts.put("rain", "Rain (JetPlane)");
        boradcasts.put("fog", "Fog (JetPlane)");
        boradcasts.put("sun", "Sun (JetPlane)");
        boradcasts.put("snow", "Snow (JetPlane)");
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);

        switch (weather) {
            case rain:
                // TODO: code expected behavior
            case fog:
                // TODO: code expected behavior
            case sun:
                // TODO: code expected behavior
            case snow:
                // TODO: code expected behavior
            default:
                throw new ALSimulationException("Unknown climate conditions: \'" + weather + "\'.");
        }
    }

    public abstract void registerTower(WeatherTower p_tower) {
        if (p_tower == null) {
            throw new ALSimulationException("No weather tower found");
        }

        weatherTower = p_tower;
        p_tower.register(this);
    }
}