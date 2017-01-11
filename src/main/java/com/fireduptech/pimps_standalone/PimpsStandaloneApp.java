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





/**
 * Entry point class into PIMPS.
 * This is a Demo learning application for accessing 
 * and reporting on data from STRAVA.
 *
 */
public class PimpsStandaloneApp
{


    public static void main( String[] args ) throws IOException
    {


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

        /**
         * ------ Authorisation Code ------
         * Firstly provide the user with a URL to put in to the browser to get the returned \
         * authorisation code which will be copied into this app then
         */ 
        System.out.println( "In order to gain access to your Strava details, the SCTM app requires you to grant access to it via Strava." );
        System.out.println( "Please copy the following Strava Authorisation URL into your browser." );
        System.out.println( "It will require you to log into your Strava account and then it will redirect to the Authorsation page.");
        System.out.println( "The Authorisation code will appear in the URL after the &code= section in the URL." ); 
        System.out.println( "Please copy that code and provide it into command prompt that follows." );

        //System.out.println( "https://www.strava.com/oauth/authorize?client_id=11430&response_type=code&redirect_uri=http://localhost&approval_prompt=force" );
        System.out.println( "https://www.strava.com/oauth/authorize?client_id=11430&response_type=code&redirect_uri=http://strava.com/dashboard&approval_prompt=force" );

        String authorisationCode = c.readLine( "Please enter the Authorisation Code from the browser URL that Strava provided:" );


        System.out.println( "The code you entered is: " + authorisationCode );


        boolean authenticated = athleteStatsController.authenticateClient( authorisationCode ); // This will get and save the Token in the Athlete Controller


        if ( authenticated ) {

            float totalDistanceCycled = athleteStatsController.getTotalDistanceCycled();  

            System.out.println( "The Total Distance Cycled is: " + totalDistanceCycled );

        } else {

            System.out.println( "Failed to authenticate the client." );
        }






	    /* UNCOMMENT THIS WHEN READY TO DIRECT USER TO STRAVA TO GET THE AUTHORISATION CODE DURING OAUTH PROCESS...
		try {

			openExternalBrowserLink( new URI( url ) );

		} catch ( URISyntaxException urie) {
			urie.printStackTrace();
		}
		*/


    }




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






