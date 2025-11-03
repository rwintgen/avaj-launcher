package io.github.rwintgen.avaj_launcher.exceptions;

public class ALParsingException extends ALException {

    public ALParsingException(String msg) {
        super("Parsing Error: " + msg);
    }
}
