package com.fireduptech.pimps_standalone.domain;




public class StravaStatsAllRideTotals {

    private int count;
    private double distance;
    private int moving_time;
    private int elevation_gain;

    public int getCount() {
        return this.count;
    }

    public double getDistance() {
        return this.distance;
    }

    public int getMovingTime() {
        return this.moving_time;
    }

    public int getElevationGain() {
        return this.elevation_gain;
    }
}