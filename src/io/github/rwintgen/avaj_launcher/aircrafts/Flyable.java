package io.github.rwintgen.avaj_launcher.aircrafts;

import io.github.rwintgen.avaj_launcher.buildings.WeatherTower;
import io.github.rwintgen.avaj_launcher.exceptions.ALSimulationException;

public interface Flyable {

    public void updateConditions() throws ALSimulationException;
    public void registerTower(WeatherTower p_tower) throws ALSimulationException;
}