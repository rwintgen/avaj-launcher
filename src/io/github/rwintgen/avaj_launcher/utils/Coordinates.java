package io.github.rwintgen.avaj_launcher.utils;

public final class Coordinates {

    private final int longitude;
    private final int latitude;
    private final int height;

    public Coordinates(int p_longitude, int p_latitude, int p_height) {
        if (p_longitude < 1) {
            throw new IllegalArgumentException("longitude must be > 0 (current: " + p_longitude + ").");
        }
        if (p_latitude < 1) {
            throw new IllegalArgumentException("latitude must be > 0 (current: " + p_latitude + ").");
        }
        if (p_height < 0 || p_height > 100) {
            throw new IllegalArgumentException("height must be between 0 and 100 (current: " + p_height + ").");
        }

        longitude = p_longitude;
        latitude = p_latitude;
        height = p_height;
    }

    public int getLongitude() {
        return (longitude);
    }

    public int getLatitude() {
        return (latitude);
    }

    public int getHeight() {
        return (height);
    }
}