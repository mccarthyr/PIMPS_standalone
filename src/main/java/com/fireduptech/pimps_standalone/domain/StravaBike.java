package com.fireduptech.pimps_standalone.domain;

public class StravaBike {

    private String id;
    private boolean primary;
    private String name;
    private double distance;

    public String getName() {
        return this.name;
    }

    public double getDistance() {
        return this.distance;
    }

    public boolean getPrimary() {
        return this.primary;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append( this.name + " - " );
        sb.append( this.distance + " - "  );
        sb.append( this.primary );
        return sb.toString();
    }

}