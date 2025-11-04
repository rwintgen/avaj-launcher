package io.github.rwintgen.avaj_launcher.buildings;

import io.github.rwintgen.avaj_launcher.aircrafts.Flyable;
import io.github.rwintgen.avaj_launcher.exceptions.ALSimulationException;
import io.github.rwintgen.avaj_launcher.utils.Writer;
import java.util.ArrayList;
import java.util.List;

public class Tower {

    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable p_flyable) throws ALSimulationException {
        if (p_flyable != null) {
            observers.add(p_flyable);
            Writer.getInstance().write("Tower says: " + p_flyable.getFullId() + " registered to weather tower.");
        }
    }

    public void unregister(Flyable p_flyable) throws ALSimulationException {
        if (p_flyable != null) {
            observers.remove(p_flyable);
            Writer.getInstance().write(p_flyable.getFullId() + " landing.");
            Writer.getInstance().write("Tower says: " + p_flyable.getFullId() + " unregistered from weather tower.");
        }
    }

    protected void conditionsChanged() throws ALSimulationException {
        if (observers.size() == 0) {
            throw new ALSimulationException("All aircrafts have landed, stopping simulation.");
        }
        for (Flyable f : new ArrayList<>(observers)) {
            f.updateConditions();
        }
    }
}