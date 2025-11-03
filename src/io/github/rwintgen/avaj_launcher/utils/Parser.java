package io.github.rwintgen.avaj_launcher.utils;

import io.github.rwintgen.avaj_launcher.exceptions.ALParsingException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class Parser {

    private Parser() {
    };

    private static void checkFileName(String fileName) throws ALParsingException {
        if (fileName == null || fileName.isEmpty() || !fileName.endsWith(".txt")) {
            throw new ALParsingException("Invalid file name or extension.");
        }
    }

    private static List<String> readFile(String fileName) throws ALParsingException {
        try {
            List<String> fileContents = Files.readAllLines(Paths.get(fileName));

            if (fileContents == null || fileContents.isEmpty()) {
                throw new ALParsingException("File is empty.");
            }
            return (fileContents);
        } catch (IOException e) {
            throw new ALParsingException("Unable to read file: \'" + fileName + "\'.");
        }
    }

    private static List<String> formatFileContents(List<String> fileContents) throws ALParsingException {
        fileContents.removeIf(line -> line == null || line.trim().isEmpty());

        if (fileContents.isEmpty()) {
            throw new ALParsingException("File is empty.");
        }
        return (fileContents);
    }

    private static Scenario extractScenarioData(List<String> content) throws ALParsingException {
        int i = 0;
        String line = null;

        try {
            int runs;

            line = content.get(i++);
            runs = Integer.parseInt(line);

            if (runs < 1) {
                throw new NumberFormatException();
            }

            List<Scenario.AircraftSpecs> aircraftSpecs = new ArrayList<>();

            while (i < content.size()) {
                line = content.get(i);
                String[] tokens = line.split("\\s+");

                if (tokens.length != 5) {
                    throw new ALParsingException("Invalid data format at line " + (i + 1) + ": \'" + line + "\'.");
                }

                String type = tokens[0].toLowerCase();
                String name = tokens[1].toLowerCase();
                int longitude = Integer.parseInt(tokens[2]);
                int latitude = Integer.parseInt(tokens[3]);
                int height = Integer.parseInt(tokens[4]);

                if (!type.equals("baloon") && !type.equals("helicopter") && !type.equals("jetplane")) {
                    throw new ALParsingException("Invalid aircraft type at line " + (i + 1) + ": \'" + type + "\'.");
                }
                if (longitude < 1 || latitude < 1 || height < 0 || height > 100) {
                    throw new NumberFormatException();
                }

                Coordinates coords = new Coordinates(longitude, latitude, height);
                aircraftSpecs.add(new Scenario.AircraftSpecs(type, name, coords));

                i++;
            }
        
            return (new Scenario(runs, aircraftSpecs));
        } catch (NumberFormatException e) {
            throw new ALParsingException("Invalid data at line " + i + ": \'" + line + "\'.");
        }
    }

    public static Scenario parseScenarioFile(String fileName) throws ALParsingException {
        checkFileName(fileName);
        List<String> fileContents = readFile(fileName);
        List<String> formattedFileContents = formatFileContents(fileContents);
        Scenario scenarioData = extractScenarioData(formattedFileContents);
        return (scenarioData);
    }
}
