package io.github.rwintgen.avaj_launcher.buildings;

import io.github.rwintgen.avaj_launcher.utils.Coordinates;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates p_coordinates) {
        return (WeatherProvider.getInstance().getCurrentWeather());
    }

    public void changeWeather () {
        this.conditionsChanged();
    }
}