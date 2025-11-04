package io.github.rwintgen.avaj_launcher.utils;

public final class WeatherProvider {

    private static WeatherProvider instance;
    private final String[] weather = { "sun", "rain", "fog", "snow" };

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

        int seed = p_coordinates.getLongitude() + p_coordinates.getLatitude() + p_coordinates.getHeight();
        int index = (seed + 42) % 4;

        return (weather[index]);
    }
}
