package io.github.rwintgen.avaj_launcher.exceptions;

public class AvajLauncherException extends Exception {
    public AvajLauncherException(String msg) {
        super("Error: " + msg);
    }
}