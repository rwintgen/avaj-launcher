package io.github.rwintgen.avaj_launcher;

import io.github.rwintgen.avaj_launcher.exceptions.AvajLauncherParsingException;

class Parser {
    private static void checkFileName (String fileName) throws AvajLauncherParsingException {
        if (fileName == null || fileName.isEmpty() || !fileName.endsWith(".txt")) {
            throw new AvajLauncherParsingException("Invalid file name or extension.");
        }
    }

    protected static void parseScenarioFile (String fileName) throws AvajLauncherParsingException {
        try {
            checkFileName(fileName);
            // type fileContents = readFile(fileName);
            // type data = createDataObject(fileContents)
        }
        catch (Exception e) {
            throw e;
        }
    }
}