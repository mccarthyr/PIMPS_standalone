package com.fireduptech.pimps_standalone;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import java.io.Console;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fireduptech.pimps_standalone.controller.AthleteStatsController;

//import java.io.InputStream;
//import java.io.OutputStream;

//import java.text.MessageFormat;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import com.fireduptech.pimps_standalone.Constants;


/*  ------ NOTE: LOOK AT IMPLEMENTING THIS FEATURE IDEA ------

PUT IN A FEATURE THAT WHEN IT LOADS IT CHECKS IF THE PROPERTIES ARE SET FOR CLIENT ID AND SECRET.
IF THEY ARE NOT SET THEN IT ALLOWS YOU TO ENTER THEM, ELSE IF THEY ARE SET IT CONTINUES AS NORMAL...
MAYBE SEE IF THIS COULD BE DONE USING A BEAN PREPROCESSOR ALTHOUGH THAT MIGHT NOT MAKE SENSE - COULD
SEE IF IT COULD BE DONE USING SOME INIT ARGUMENT IN THE XML - ???

*/


/**
 * Entry point class into PIMPS.
 * This is a Demo learning application for accessing 
 * and reporting on data from STRAVA.
 *
 */
public class PimpsStandaloneApp
{

    private static String stravaRequestMenuOption = null;
    private static String stravaRequestAPIEndpoint = null;
    private static boolean requestURIVariableSubstitution = false;


    public static void main( String[] args ) throws IOException
    {

/*
		ApplicationContext context = new ClassPathXmlApplicationContext(
			"classpath:META-INF/spring/applicationContext.xml");


        AthleteStatsController athleteStatsController = (AthleteStatsController) context.getBean("controller");


        System.out.println( "-----------------------------------------------------------" );
        System.out.println( "Welcome to the Personalised Information Metrics Pulled from STRAVA (PIMPS) application." );
        System.out.println( "-----------------------------------------------------------" );

        Console c = System.console();
        if ( c == null ) {
            System.err.println("There is no console available on this operating system.");
            System.exit(1);
        }
*/

        /**
         * ------ Authorisation Code ------
         * Firstly provide the user with a URL to put in to the browser to get the returned \
         * authorisation code which will be copied into this app then
         */ 
 /*       System.out.println( "In order to gain access to your Strava details, the SCTM app requires you to grant access to it via Strava." );
        System.out.println( "Please copy the following Strava Authorisation URL into your browser." );
        System.out.println( "It will require you to log into your Strava account and then it will redirect to the Authorsation page.");
        System.out.println( "The Authorisation code will appear in the URL after the &code= section in the URL." ); 
        System.out.println( "Please copy that code and provide it into command prompt that follows." );

        System.out.println( "https://www.strava.com/oauth/authorize?client_id=11430&response_type=code&redirect_uri=http://strava.com/dashboard&approval_prompt=force" );

        String authorisationCode = c.readLine( "Please enter the Authorisation Code from the browser URL that Strava provided:" );

        System.out.println( "The code you entered is: " + authorisationCode );


        // This will get and save the Token in the Athlete Controller
        boolean authenticated = athleteStatsController.authenticateClient( authorisationCode );
*/

        // Call to private method that will give the User the App Feature Options
        provideAppFeatureOptionsToUser();  // The 'stravaRequestOption' is set within that method for now...

        /*
        AS THE RETURNED VALUES AND WHAT IS THE BE DISPLAYED FROM EACH REQUEST WILL VARY, FOR NOW THERE COULD BE A SECOND CALL TO PRINT THE 
        VALUES OF THE REQUEST FROM THE CONTROLLER SO THAT WAY IT HAS THE LOGIC FOR EACH ONE AND ARE NOT TRYING TO CATER FOR VARIOUS RETURN TYPES HERE...
        JUST A CALL TO EACH RELEVANT PRINT METHOD FROM THE CONTROLLER BASED ON THE MENU OPTION CHOSEN FROM HERE...
        WILL TRY THIS WAY FIRST, CAN RE-DESIGN LATER THEN ONCE SEE IT WORKING - THE MORE OF THESE I DO THE EASIER AND FASTER IT WILL BE TO DESIGN LATER ON... 

        all these data calls for the API are GET requests...
        */


//        boolean retrievedData = athleteStatsController.requestDataFromStravaAPI( stravaRequestMenuOption, stravaRequestAPIEndpoint, requestURIVariableSubstitution );

  


        // -- NEED TO PROVIDE INPUT VALIDATION CODE ---> THIS COULD BE PART OF STRUCTURAL FEATURE UPGRADE FOR V1.4...
        System.exit(0);

/*        if ( authenticated ) {

            float totalDistanceCycled = athleteStatsController.getTotalDistanceCycled();  

            System.out.println( "The Total Distance Cycled is: " + totalDistanceCycled );

        } else {

            System.out.println( "Failed to authenticate the client." );
        }
*/

	    /* UNCOMMENT THIS WHEN READY TO DIRECT USER TO STRAVA TO GET THE AUTHORISATION CODE DURING OAUTH PROCESS...
		try {

			openExternalBrowserLink( new URI( url ) );

		} catch ( URISyntaxException urie) {
			urie.printStackTrace();
		}
		*/
    }

    /*
    1. Get current Athlete details 

    2. Get heart rate zones.

    3. Get Athlete Totals & Stats

    4. List all activities - from this get a summation of the Activity Ids and Activity Names along with a full count. 

    5. Get a specific Activity and show some stats from it.
    */
    private static void provideAppFeatureOptionsToUser() {

        Console c = System.console();

        // provide the options available to the user...
        System.out.println( "Please enter the number from one of the following options:" );
        System.out.println( "----------------------------------------------------------" );

        stravaRequestMenuOption = c.readLine( "1 - Athlete Summary %n2 - Athlete Heart Rate Zones %n3 - Athlete Totals%n4 - Summary Athlete Activities%n5 - Activity Details%n%n" );


        System.out.format( "You chose option %s%n", stravaRequestMenuOption );


        switch ( stravaRequestMenuOption ) {
            case Constants.ATHLETE_SUMMARY_MENU_OPTION:
                System.out.println( Constants.ATHLETE_SUMMARY_API_ENDPOINT );
                stravaRequestAPIEndpoint = Constants.ATHLETE_SUMMARY_API_ENDPOINT;
                break;

            case Constants.ATHLETE_HEART_RATE_ZONES_MENU_OPTION:
                System.out.println( Constants.ATHLETE_HEART_RATE_ZONES_API_ENDPOINT );
                stravaRequestAPIEndpoint = Constants.ATHLETE_HEART_RATE_ZONES_API_ENDPOINT;
                break;

            case Constants.ATHLETE_TOTALS_MENU_OPTION:
                System.out.println( Constants.ATHLETE_TOTALS_API_ENDPOINT );
                stravaRequestAPIEndpoint = Constants.ATHLETE_TOTALS_API_ENDPOINT;

                requestURIVariableSubstitution = true;  
/*                NEED A WAY TO ASSOCIATE WHAT VALUE IS TO BE SUBSTITUTED???
                OK SO IF NEEDS SUBSTITUTION, THEN IN THE CONTROLLER THERE IS A MAPPING TAKEN FROM CONSTANTS THAT MAPS
                MENU NAME TO A VARIABLE NAME..HHMM NOT SURE AS THE VARIABLE NAME IN THE FILE WOULD NEED TO MATCH IN THE CODE - THIS IS 
                REQUIRING IT IN TWO PLACES...

                COULD HAVE A MAP IN CODE JUST IN THE CONTROLLER CLASS THAT HAS A MAPPING OF API REQUEST OR MENU NAME TO VARIABLE NAME...???


PUT IN SAMPLE MAP CODE HERE TO RUN AND CHECK...
<util:map id="requestURLVariableSubstitutionMap" map-class="java.util.Map" >
             <entry key="1" value="athleteId"/>
             <entry key="3" value="activityId"/>
            </util:map>
*/




                //message = Constants.ATHLETE_TOTALS_API_ENDPOINT;
                //message = String.format( message, aId );  

                break;

            case Constants.ATHLETE_SUMMARY_ACTIVITIES_MENU_OPTION:
                System.out.println( Constants.ATHLETE_SUMMARY_ACTIVITIES_API_ENDPOINT );
                stravaRequestAPIEndpoint = Constants.ATHLETE_SUMMARY_ACTIVITIES_API_ENDPOINT;
                break;

            case Constants.ATHLETE_ACTIVITY_DETAILS_MENU_OPTION:
                System.out.println( Constants.ATHLETE_ACTIVITY_DETAILS_API_ENDPOINT );
                stravaRequestAPIEndpoint = Constants.ATHLETE_ACTIVITY_DETAILS_API_ENDPOINT;
                
                //System.out.println( String.format( Constants.ATHLETE_ACTIVITY_DETAILS_API_ENDPOINT, actId ) );
                break;

            default:
                System.out.println( "Please enter a value from the menu options" );   // ??? REPLACES THIS WITH A THROW EXCEPTION ???
                break;
        } 

        System.exit(0);


      





    }   // End of method provideAppFeatureOptionsToUser()...


    /**
     * Open web browser with provided URI
     */
    public static void openExternalBrowserLink(URI uri) {

    	Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
    	
    	if ( desktop != null && desktop.isSupported( Desktop.Action.BROWSE ) ) {

    		System.out.println("Your DESKTOP is supported...");
    		System.exit(0);

    		try {
    				desktop.browse( uri );
    		} catch ( IOException e ) {
    			e.printStackTrace();
    		}    		
    	} /* else{
            Runtime runtime = Runtime.getRuntime();
            try {
            	// This is for Linux, XServer system
              runtime.exec("xdg-open " + url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } */
    }



}






