package io.github.rwintgen.avaj_launcher.aircrafts;

import io.github.rwintgen.avaj_launcher.buildings.WeatherTower;

public interface Flyable {

    public void updateConditions();
    public void registerTower(WeatherTower p_tower);
}