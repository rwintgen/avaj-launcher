package io.github.rwintgen.avaj_launcher;

import java.io.FileNotFoundException;

class Parser {
    private static void checkFileName (String fileName) throws FileNotFoundException {
        if (fileName == null || fileName.isEmpty() || !fileName.endsWith(".txt")) {
            throw new FileNotFoundException("Invalid file name or extension.");
        }
    }

    protected static void parseScenarioFile (String fileName) {
        try {
            checkFileName(fileName);
            // type fileContents = readFile(fileName);
            // type data = createDataObject(fileContents)
        }
        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
            // Throw custom exception?
        }
    }
}