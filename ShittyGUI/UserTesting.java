package ShittyGUI;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static Enumeration.Enumeration.*;
import Database.DatabaseTranslator;
import java.io.IOException;
import Database.LoadData;
import models.VacationLocation;
import models.User.*;
import models.User;
import static Enumeration.Enumeration.*;
import api.APITranslator;
import com.amadeus.exceptions.ResponseException;
import java.util.ArrayList;
import java.util.Arrays;
import models.CreateUserFromInput;
import models.CreateVacationLocationFromInput;
import models.RegisterUser;

/**
 * Lasted Updated: 11/10/19
 * Shitty text based GUI purely for testing functionality before final GUI is ready for integration.
 * @authors Steve Shay
 */
public class UserTesting {
    static Scanner scn = new Scanner(System.in);
    static ArrayList<String> agrees = new ArrayList<String>(Arrays.asList("Y", "y"));
    public static void main(String[] args) throws ResponseException, IOException{
        User newUser;
        System.out.println("Welcome to the American Travel Bucket List!");
        System.out.println("Here to help you pick a vacation when you can't decide.");
        System.out.println("");
        System.out.println("Please enter your name. New users will be routed to the interst Questionaire: ");

        String username = scn.nextLine();
        String filepath = USER_FILEPATH + username + TXT;
        File inputfile = new File(filepath);

        if (!inputfile.exists()){
            System.out.println("Welcome " + username + " as a new user we need to ask you a few questions");
            System.out.println("so we can help you plan vacations you will enjoy.");
            System.out.println("");
            System.out.println("What is your local Zip Code (for finding flight costs): ");
            int zip = scn.nextInt();
            newUser = RegisterUser.newUser(username, zip);

            System.out.println("");
            System.out.println("Catagories: ");
            catagories(newUser);
            if (newUser.getSingleCategory(0) == TRUE){
                System.out.println("Outdoors Adventures: ");
                outdoorsLocations(newUser);
            }
            if (newUser.getSingleCategory(1) == TRUE){
                System.out.println("Entertainment Vacations");
                entertainmentLocations(newUser);
            }
            if (newUser.getSingleCategory(2) == TRUE){
                System.out.println("Educational Entertainment Vacations");
                educationalLocations(newUser);
            }
            if (newUser.getSingleCategory(3) == TRUE){
                System.out.println("Cultural Vacations");
                culturalLocations(newUser);
            }
            if (newUser.getSingleCategory(4) == TRUE){
                System.out.println("Historical Vacations");
                historicalLocations(newUser);
            }
            System.out.println("Thank you. Storing Reponses.");
            RegisterUser.storeUser(newUser.getName(), newUser.getZipCode(), newUser.getAirportCode(), newUser.getCategories(), newUser.getUserResponses());
        }
        else {
            String userFileData = DatabaseTranslator.getUserData(username);
            String[] userData = userFileData.split(INPUT_SPLIT);

            newUser = CreateUserFromInput.createUser(userData);
        }
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("Are you ready to select a random destination based on your questionairte responses?: (Y/N)");
        String response = scn.next();
        if (agrees.contains(response)){
            int selection = newUser.selectRandomDestination();

            String locationFileData = DatabaseTranslator.getLocationData("Location" + selection);
            String[] locationData = locationFileData.split(INPUT_SPLIT);

            VacationLocation destination = CreateVacationLocationFromInput.createLocation(locationData);
            double flightCost = APITranslator.getExpectedFlightCost(newUser.getAirportCode(), destination.getAirportCode(), "2019-12-22");
            String strFlightCost = String.format("%.2f", flightCost);
            double hotelCost = APITranslator.getExpectedHotelCost(destination.getCityCode());
            String strHotelCost = String.format("%.2f", hotelCost);

            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");

            System.out.println("We've selected " + destination.getName() + " from your list of interests.");
            System.out.println("Based on where you live you can expect to pay " + strFlightCost + " per person to fly to " + destination.getName() + ".");
            System.out.println("In " + destination.getName() +  " you can expect to pay " + strHotelCost + " per night for a room.");
            System.out.println(destination.getDescription());
        }
        else{
            System.out.println("Thank you for using the American Travel Buket List. Logging you out.");
            System.exit(0);
        }
    }

    private static void catagories(User _user){
        String response = "";
        String[] catagories = {"1. Outdoor Adventure", "2. Entertainment", "3. Educational Entertainment", "4. Cultural", "5. Historical"};
        for (int i = 0; i < 5; i++){
            System.out.println("Are you interested in " + catagories[i] + " vacations? (Y/N)");
            response = scn.next();

            if (agrees.contains(response)){
                _user.setSingleCategory(i, TRUE);
            }
            else{
                _user.setSingleCategory(i, FALSE);
            }
        }
    }

    private static void outdoorsLocations(User _user){
        String response = "";
        String[] locations = {"Acadia National Park", "Anchorage Alaska","Boulder Colorado","Grand Canyon","Yellowstone"};
        for (int i = 0; i < 5; i++){
            System.out.println("Are you interested in going on a vacation to " + locations[i] + "? (Y/N)");
            response = scn.next();

            if (agrees.contains(response)){
                _user.setSingleResponse(i, TRUE);
            }
            else{
                _user.setSingleResponse(i, FALSE);
            }
        }
    }

    private static void entertainmentLocations(User _user){
        String response = "";
        String[] locations = {"Disney World", "Las Vegas","The Mall of America","Ocean City Beach","Six Flags Over Georgia"};
        for (int i = 0; i < 5; i++){
            System.out.println("Are you interested in going on a vacation to " + locations[i] + "? (Y/N)");
            response = scn.next();

            if (agrees.contains(response)){
                _user.setSingleResponse(5 + i, TRUE);
            }
            else{
                _user.setSingleResponse(5 + i, FALSE);
            }
        }
    }

    private static void educationalLocations(User _user){
        String response = "";
        String[] locations = {"The Childrens Museum of Indianapolis", "The Georgia Aquarium","The San Diego Zoo","Sea World Orlando","The Smithsonian Museum"};
        for (int i = 0; i < 5; i++){
            System.out.println("Are you interested in going on a vacation to " + locations[i] + "? (Y/N)");
            response = scn.next();

            if (agrees.contains(response)){
                _user.setSingleResponse(10 + i, TRUE);
            }
            else{
                _user.setSingleResponse(10 + i, FALSE);
            }
        }
    }

    private static void culturalLocations(User _user){
        String response = "";
        String[] locations = {"Boston", "Honolulu","New Orleans","New York","San Francisco"};
        for (int i = 0; i < 5; i++){
            System.out.println("Are you interested in going on a vacation to " + locations[i] + "? (Y/N)");
            response = scn.next();

            if (agrees.contains(response)){
                _user.setSingleResponse(15 + 1, TRUE);
            }
            else{
                _user.setSingleResponse(15 + i, FALSE);
            }
        }
    }

    private static void historicalLocations(User _user){
        String response = "";
        String[] locations = {"The Alamo", "Alcatraz","Gettysburg","The Kennedy Space Center","Washington DC"};
        for (int i = 0; i < 5; i++){
            System.out.println("Are you interested in going on a vacation to " + locations[i] + "? (Y/N)");
            response = scn.next();

            if (agrees.contains(response)){
                _user.setSingleResponse(20 + i, TRUE);
            }
            else{
                _user.setSingleResponse(20 + i, FALSE);
            }
        }
    }
}

