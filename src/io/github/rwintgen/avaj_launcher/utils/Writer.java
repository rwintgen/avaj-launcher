package io.github.rwintgen.avaj_launcher.utils;

import io.github.rwintgen.avaj_launcher.exceptions.ALSimulationException;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public final class Writer {

    private static Writer instance;
    private BufferedWriter writer;

    private Writer() {
    }

    public static Writer getInstance() {
        if (instance == null) {
            instance = new Writer();
        }
        return instance;
    }

    public void init(Path path) throws ALSimulationException {
        try {
            if (writer == null) {
                writer = Files.newBufferedWriter(path, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            }
            else {
                throw new ALSimulationException("Already existing file 'simulation.txt'");
            }
        } catch (IOException e) {
            throw new ALSimulationException("Unable to open file 'simulation.txt': " + e.getMessage());
        }
    }

    public void writeToOutput(String line) throws ALSimulationException {
        if (writer == null) {
            throw new ALSimulationException("Writer not initialized");
        }
        try {
            writer.write(line);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            throw new ALSimulationException("Error while writing in 'simulation.txt': " + e.getMessage());
        }
    }

    public void close() throws ALSimulationException {
        if (writer == null) {
            return;
        }
        try {
            writer.close();
            writer = null;
        } catch (IOException e) {
            throw new ALSimulationException("Error while closing 'simulation.txt': " + e.getMessage());
        }
    }
}
