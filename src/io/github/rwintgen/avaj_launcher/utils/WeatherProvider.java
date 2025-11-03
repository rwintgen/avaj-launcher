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

        // Simple generation algorithm that returns any coordinates' weather
        int seed = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();
        index = seed + 42 % 4;

        return (weather[index]);
    }
}
