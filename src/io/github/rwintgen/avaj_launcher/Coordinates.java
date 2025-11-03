package io.github.rwintgen.avaj_launcher;

public final class Coordinates {

    private final int longitude;
    private final int latitude;
    private final int height;

    public Coordinates(int longitude, int latitude, int height) {
        if (longitude < 0) {
            throw new IllegalArgumentException("longitude must be >= 0");
        }
        if (latitude < 0) {
            throw new IllegalArgumentException("latitude must be >= 0");
        }
        if (height < 0 || height > 100) {
            throw new IllegalArgumentException("height must be between 0 and 100");
        }

        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }
}