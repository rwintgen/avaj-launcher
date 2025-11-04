package io.github.rwintgen.avaj_launcher.buildings;

import io.github.rwintgen.avaj_launcher.exceptions.ALSimulationException;
import io.github.rwintgen.avaj_launcher.utils.Coordinates;
import io.github.rwintgen.avaj_launcher.utils.WeatherProvider;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        return (WeatherProvider.getInstance().getCurrentWeather(coordinates));
    }

    public void changeWeather() throws ALSimulationException{
        this.conditionsChanged();
    }
}