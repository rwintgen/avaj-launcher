package io.github.rwintgen.avaj_launcher.utils;

public final class WeatherProvider {

    private static WeatherProvider instance;

    private final String[] weather = { "SUN", "RAIN", "FOG", "SNOW" };

    private WeatherProvider() {
    }

    public static WeatherProvider getInstance() {
        if (instance == null) {
            instance = new WeatherProvider();
        }
        return instance;
    }

    public String getCurrentWeather(Coordinates p_coordinates) {
        if (p_coordinates == null) {
            throw new IllegalArgumentException("coordinates must not be null");
        }

        // TODO get weather from coordinates and return it
    }
}
