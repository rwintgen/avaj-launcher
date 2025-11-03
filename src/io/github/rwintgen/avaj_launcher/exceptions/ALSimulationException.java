package io.github.rwintgen.avaj_launcher.exceptions;

public class ALSimulationException extends ALException {

    public ALSimulationException(String msg) {
        super("Simulation Error: " + msg);
    }
}
