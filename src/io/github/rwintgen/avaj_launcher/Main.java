package io.github.rwintgen.avaj_launcher;

public class Main {
    public static void main(String[] args) {
        try {
            if (args.length == 0 || args.length > 1) {
                throw new IllegalArgumentException("Invalid number of arguments.");
            }

            Parser.parseScenarioFile(args[0]);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}