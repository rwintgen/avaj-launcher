package io.github.rwintgen.avaj_launcher.buildings;

import io.github.rwintgen.avaj_launcher.aircrafts.Flyable;
import java.util.List;
import java.util.ArrayList;

public class Tower {

    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable p_flyable) {
        if (p_flyable != null) {
            observers.add(p_flyable);
        }
    }

    public void unregister(Flyable p_flyable) {
        if (p_flyable != null) {
            observers.remove(p_flyable);
        }
    }

    protected void conditionChanged() {
        for (Flyable f : observers) {
            f.updateCOnditions();
        }
    }
}