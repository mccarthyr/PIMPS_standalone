package com.fireduptech.pimps_standalone.domain;



public class StravaAuthenticationResponse {

    // Following naming convention from the JSON to allow mapping
    private String access_token;
    private StravaAthlete athlete;

    public StravaAthlete getStravaAthlete() {
        return this.athlete;
    }

    public String getAccessToken() {
        return this.access_token;
    }

}