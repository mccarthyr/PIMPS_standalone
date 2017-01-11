package com.fireduptech.pimps_standalone.service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;

import org.apache.http.HttpResponse;



public class HttpClientService {



	public String httpPost( String tokenUrl, int clientId, String clientSecret, String authorisationCode  ) throws IOException {

      CloseableHttpClient httpclient = HttpClients.createDefault();
      HttpPost postRequest = new HttpPost( tokenUrl );

      List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
      urlParameters.add( new BasicNameValuePair( "client_id", Integer.toString( clientId ) ) );
      urlParameters.add( new BasicNameValuePair( "client_secret", clientSecret ) );
      urlParameters.add( new BasicNameValuePair( "code", authorisationCode ) );

      postRequest.setEntity( new UrlEncodedFormEntity( urlParameters ) );

      CloseableHttpResponse response = httpclient.execute( postRequest );


			System.out.println( "Response Code: "  + response.getStatusLine().getStatusCode() );


      StringBuffer result = new StringBuffer();
      try {

          BufferedReader rd = new BufferedReader(
              new InputStreamReader( response.getEntity().getContent() ));

          String line = "";
          
          while ( ( line = rd.readLine() ) != null ) {
              result.append(line);
          }

          System.out.println( "The returned response is: \n" + result );


      } finally {
          response.close();
      }

      return result.toString();
	}



  // ****** --- API ACCESS --- ******

  // GET https://www.strava.com/api/v3/athletes/:id/stats
  /*
  $ curl -G https://www.strava.com/api/v3/athletes/227615/stats \
          -H "Authorization: Bearer 83ebeabdec09f6670863766f792ead24d61fe3f9"
  id:     integer required
      must match the authenticated athlete
  */
  // apiRequest = "https://www.strava.com/api/v3/athletes/" + athleteId +"/stats";
	public String httpGet( String apiRequest, String authorisationCode ) throws IOException {


				CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet request = new HttpGet( apiRequest );


        request.addHeader( "Authorization", "Bearer " + authorisationCode );

        CloseableHttpResponse response = httpclient.execute( request );

        System.out.println( "The Response Code is: " + response.getStatusLine().getStatusCode() );


        StringBuilder result = new StringBuilder();
        try {

            BufferedReader rd = new BufferedReader(
                new InputStreamReader( response.getEntity().getContent() ));

            String line = "";
            
            while ( ( line = rd.readLine() ) != null ) {
                result.append(line);
            }

            System.out.println( "The returned response is: \n" + result );

        } finally {
            response.close();
        }

        return result.toString();
	}




}





