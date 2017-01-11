package com.fireduptech.pimps_standalone.domain;



public class StravaAthleteStats {

    private double biggest_ride_distance;
    private double biggest_climb_elevation_gain;

    private StravaStatsAllRideTotals all_ride_totals;

    public StravaStatsAllRideTotals getAllRideTotals() {
        return this.all_ride_totals;
    }

    public double getBiggestRideDistance() {
        return this.biggest_ride_distance;
    }

    public double getBiggestClimbElevationGain() {
        return this.biggest_climb_elevation_gain;
    }

}