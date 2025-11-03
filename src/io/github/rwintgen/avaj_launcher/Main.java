package io.github.rwintgen.avaj_launcher;

import io.github.rwintgen.avaj_launcher.utils.Parser;
import io.github.rwintgen.avaj_launcher.utils.Scenario;

public class Main {

    public static void main(String[] args) {
        try {
            if (args.length == 0 || args.length > 1) {
                throw new IllegalArgumentException("Invalid number of arguments.");
            }

            Scenario scenarioData = Parser.parseScenarioFile(args[0]);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}
