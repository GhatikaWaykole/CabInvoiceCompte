package com.example;

public class CabRideData {
    private final double distance;
    private final int time;

    public CabRideData(double distance, int time) {
        this.distance = distance;
        this.time = time;
    }

    public double getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}
