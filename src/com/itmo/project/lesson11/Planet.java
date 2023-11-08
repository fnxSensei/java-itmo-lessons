package com.itmo.project.lesson11;

public enum Planet {
    MERCURY("3.302*10^23", 2440),
    VENUS ("4.869*10^24", 6052),
    EARTH ("5.974*10^24", 6378),
    MARS ("6.419*10^23", 3397),
    JUPITER ("1.899*10^27", 71490),
    SATURN ("5.685*10^26", 60270),
    URANUS ("8.685*10^25", 25560),
    NEPTUNE ("1.024*10^26", 24760),
    PLUTON("1.3*10^22", 1151);
    private String weightInKilograms;
    private int radiusInKilometres;

    Planet(String weightInKilograms, int radiusInKilometres) {
        this.weightInKilograms = weightInKilograms;
        this.radiusInKilometres = radiusInKilometres;
    }

    public String getWeightInKilograms() {
        return weightInKilograms;
    }

    public int getRadiusInKilometres() {
        return radiusInKilometres;
    }
}
