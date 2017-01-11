package com.fireduptech.pimps_standalone.service;



/**
 * NOTE: ++++++ THIS CLASS IS NOT BEING USED FOR NOW AND HAS BEEN MADE REDUNDANT ++++++
 */
public class OAuthTransportService {


	private static final String clientId = "11430";
	private static final String clientSecret = "0dcc40d724e4ec25f0417b290a3410bf1b1d09fa";

	private static final String authenticationToken = null;

	static final String URL = "https://www.strava.com/oauth/token";


	private HttpClientService httpClientService;

/*
	public Map<String,String> authenticate( String authorisationCode ) {

		Farm this out to a help method to get the token

	  initially what will happen is you get the full json back. then send off the response to a helper service that will 
	  extract the json...this might be another service class. can have it within this one for now and sort out the design a 
	  little better once have some code flowing... SO HAVE A STRAVA RESPONSE OBJECT IN HERE THAT WILL WILL MAP THE RESPONSE OR ELSE SET THAT 
	  AS A DOMAIN OBJECT FOR NOW AND IMPORT IT IN HERE??? 




		AT THE END PUT THE MAP THAT IS RETURNED TOGETHER...
		Map<String,String> securityMap = new HashMap<String, String>();
		securityMap.put( "athleteId", "..." );
		securityMap.put( "token", "..." );


	}

	public String getToken() {


		this.httpClientService.
		???
		NEED TO WRITE OUT THE PROCESS HERE - AS NOW HAVE A DEPENDENCY ON THE HTTP-CLIENT IN BOTH THIS OAUTH SERVICE CLASS AND IN THE ATHLETE CONTROLLER CLASS...
	}
*/


}