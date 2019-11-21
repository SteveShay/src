package travelbucketlist;

/**
 * Lasted Updated: 11/18/19
 * Project main class. Currently being used as a testing ground.
 * @authors Steve Shay
 */
import Database.DatabaseTranslator;
import java.io.IOException;
import Database.LoadData;
import models.VacationLocation;
import models.User.*;
import models.User;
import static Enumeration.Enumeration.*;
import api.APITranslator;
import com.amadeus.exceptions.ResponseException;
import java.util.Arrays;
import models.CreateUserFromInput;
import models.CreateVacationLocationFromInput;
import models.RegisterUser;

public class TravelBucketList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ResponseException {
        //Test loading user from file.
        String userFileData = DatabaseTranslator.getUserData("James Bond");
        String[] userData = userFileData.split(INPUT_SPLIT);

        String locationFileData = DatabaseTranslator.getLocationData("New York City");
        String[] locationData = locationFileData.split(INPUT_SPLIT);

        //Test User object data load and getters.
        User JamesTest = CreateUserFromInput.createUser(userData);
        VacationLocation NYC = CreateVacationLocationFromInput.createLocation(locationData);

        //Test zip to latitude and longitude conversion.
        double[] latAndLong = DatabaseTranslator.getLocationFromZip(JamesTest.getZipCode());
        System.out.println(latAndLong[0]);
        System.out.println(latAndLong[1]);

        //Get the airport code for that latitude and longitude.
        String aircode = APITranslator.getAirportCode(latAndLong[0], latAndLong[1]);
        System.out.println("Walkertown: " + aircode);

        //Test registering a new user.
        User newUser = RegisterUser.newUser("Dans Gaming", 27051);
        System.out.println(newUser.getName() + ", " + newUser.getZipCode() + ", " + newUser.getAirportCode());
        RegisterUser.storeUser(newUser.getName(), newUser.getZipCode(), newUser.getAirportCode(), newUser.getCategories(), newUser.getUserResponses());

        //Test selecting a random destination based on user responses.
        int selection = JamesTest.selectRandomDestination();
        if (selection == -1){
            System.out.println("You have visited all Locations on your list.");
        }
        System.out.println(selection);

        String locationFileName = JamesTest.mapFilename(selection - 1);
        String locationFileData1 = DatabaseTranslator.getLocationData(locationFileName);
        String[] locationData1 = locationFileData1.split(INPUT_SPLIT);

        //Print out the selection details.
        VacationLocation testLocation = CreateVacationLocationFromInput.createLocation(locationData1);
        System.out.println(testLocation.getName());
        System.out.println(testLocation.getCityCode());
        System.out.println("");
        System.out.println("");

        //Get the projected flight and hotel costs for the selected trip.
        double cost1 = APITranslator.getExpectedFlightCost(JamesTest.getAirportCode(), testLocation.getAirportCode(), "2019-12-22");
        System.out.format("Flight Total: %.2f", cost1);
        System.out.println("");

        double hotelPrice1 = APITranslator.getExpectedHotelCost(testLocation.getCityCode());
        System.out.format("Hotel (Cost per night): %.2f", hotelPrice1);
    }
}
