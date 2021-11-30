package com.lokey.payroll.controllers;

import com.squareup.square.Environment;
import com.squareup.square.SquareClient;
import com.squareup.square.api.LocationsApi;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.models.Error;
import com.squareup.square.models.Location;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "square")
public class SquareManager {

   @RequestMapping(value = "login", method = RequestMethod.GET)
   public String connectToSquare (){
      return "square/login";
   }

   @RequestMapping(value = "login", method = RequestMethod.POST)
   public String connectToSquare (Model model, @RequestParam String key) {
      String text = "null";
      System.out.println("Key entered: " + key);
      SquareClient client = new SquareClient.Builder()
              .environment(Environment.SANDBOX)
              .accessToken(key)
              .build();

      LocationsApi api = client.getLocationsApi();

      try {
         List<Location> locations = api.listLocations().getLocations();
         // Your business logic code
         System.out.println("calling listLocations successfully");
         text="successfully populated Location list";

      } catch (
              ApiException e) {
         List<Error> errors = e.getErrors();
         int statusCode = e.getResponseCode();
         HttpContext httpContext = e.getHttpContext();

         // Your error handling code
         System.err.println("ApiException when calling API");
         text = "ApiException when calling API";
         e.printStackTrace();
      } catch (
              IOException e) {
         // Your error handling code
         System.err.println("IOException when calling API");
         text = "IOException when calling API";
         e.printStackTrace();
      }

      //LaborApi laborApi = client.getLaborApi();



      model.addAttribute("text", text);
      return "square/connect";
   }






    /*private final String _accessToken = "#######";

    // The ID of the location you want to create an item for.
    // See PaymentsReporter.java for an example of getting a business's location IDs.
    private final String _locationId = "REPLACE_ME";

    // The base URL for every Connect API request
    private final String _connectHost = "https://connect.squareup.com";

    // Constructor that sets headers common to every Connect API request
    public void ItemManager() {
        Unirest.setDefaultHeader("Authorization", "Bearer " + _accessToken);
        Unirest.setDefaultHeader("Content-Type", "application/json");
        Unirest.setDefaultHeader("Accept", "application/json");
    }*/
}
