package io.github.rwintgen.avaj_launcher;

import io.github.rwintgen.avaj_launcher.exceptions.AvajLauncherParsingException;
import java.io.IOException;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

class Parser {
    private static void checkFileName (String fileName) throws AvajLauncherParsingException {
        if (fileName == null || fileName.isEmpty() || !fileName.endsWith(".txt")) {
            throw new AvajLauncherParsingException("Invalid file name or extension.");
        }
    }

    private static List<String> readFile(String fileName) throws AvajLauncherParsingException {
        try {
            List<String> fileContents = Files.readAllLines(Paths.get(fileName));
            return (fileContents);
        } catch (IOException e) { // Convert readAllLines' IOException into custom AvajLauncherParsingException
            throw new AvajLauncherParsingException("Unable to read file: " + fileName);
        }
    }

    protected static void parseScenarioFile (String fileName) throws AvajLauncherParsingException {
        checkFileName(fileName);
        List<String> fileContents = readFile(fileName);
        // validateAndFormatFileContents(fileContents)
        // new Scenario scenarioData(fileContents);
    }
}