package com.fireduptech.pimps_standalone.domain;

import com.fireduptech.pimps_standalone.domain.StravaBike;

/* --- Example of the Athelete section within the JSON response...
"athlete":{
    "id":7209970,"username":"richardmccarthy","resource_state":3,"firstname":"Richard","lastname":"McCarthy",
        "profile_medium":"https://dgalywyr863hv.cloudfront.net/pictures/athletes/7209970/3988522/2/medium.jpg",
        "profile":"https://dgalywyr863hv.cloudfront.net/pictures/athletes/7209970/3988522/2/large.jpg","city":"Tralee","state":"Kerry",
        "country":"Ireland","sex":"M","premium":false,"created_at":"2014-12-01T16:19:51Z","updated_at":"2016-05-18T14:46:20Z",
        "badge_type_id":0,"friend":null,"follower":null,"follower_count":7,"friend_count":9,"mutual_friend_count":0,"athlete_type":0,
        "date_preference":"%m/%d/%Y","measurement_preference":"meters","email":"mccarthy.richard@gmail.com","ftp":null,"weight":83.2,
        "clubs":[],"bikes":[{"id":"b2696123","primary":true,"name":"Prestigio","resource_state":2,"distance":1229785.0}],"shoes":[]
}
*/

public class StravaAthlete {

    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String city;
    private String country;
    private double weight;

    private StravaBike[] bikes;

    public StravaBike[] getBikes() {
        return bikes;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder( "Strava Athlete details: " );
        //sb.append( this.username + " - " + this.city + " -  ( " + bikes + " )" );
        sb.append( this.username + " - " + this.city + " -  ( ");
        for ( StravaBike bike : bikes ) {
            sb.append( bike );
        }
        sb.append( " )"  );

        return sb.toString();
    }
}
