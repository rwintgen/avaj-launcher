package io.github.rwintgen.avaj_launcher.exceptions;

public class ALException extends Exception {

    public ALException(String msg) {
        super("Error: " + msg);
    }
}
