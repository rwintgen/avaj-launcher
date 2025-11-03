package io.github.rwintgen.avaj_launcher.aircrafts;

import io.github.rwintgen.avaj_launcher.weather.WeatherTower;

public interface Flyable {

    void updateConditions();
    void registerTower(WeatherTower* p_tower);
}