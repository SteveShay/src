package travelbucketlist;

/**
 * Lasted Updated: 11/21/19
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
    static User currentUser1;
    static User currentUser2;
    static VacationLocation location1;
    static VacationLocation location2;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ResponseException {
        //Test loading user from file.
        currentUser1 = loadUser("James Bond");

        location1 = loadLocation("New York City");

        //Test registering a new user.
        currentUser2 = RegisterUser.newUser("Dans Gaming", 27051);
        //System.out.println(currentUser2.getName() + ", " + currentUser2.getZipCode() + ", " + currentUser2.getAirportCode());
        RegisterUser.storeUser(currentUser2.getName(), currentUser2.getZipCode(), currentUser2.getAirportCode(), currentUser2.getCategories(), currentUser2.getUserResponses());
        currentUser2.setSingleResponse(25, 44);
        currentUser2.overwriteUser();

        //Test selecting a random destination based on user responses.
        int selection = currentUser1.selectRandomDestination();
        if (selection == -1){
            System.out.println("You have visited all Locations on your list.");
        }
        location2 = loadLocation(currentUser1.mapFilename(selection));
        //Get the projected flight and hotel costs for the selected trip.
        getFlightAndHotel();
    }

    static User loadUser(String _name) throws IOException{
        if(DatabaseTranslator.checkUser(_name)){
            String userFileData = DatabaseTranslator.getUserData(_name);
            String[] userData = userFileData.split(INPUT_SPLIT);
            return CreateUserFromInput.createUser(userData);
        }
        else{
            throw new AssertionError();
        }
    }

    static VacationLocation loadLocation(String _name) throws IOException{
        String locationFileData = DatabaseTranslator.getLocationData(_name);
        String[] locationData = locationFileData.split(INPUT_SPLIT);
        return CreateVacationLocationFromInput.createLocation(locationData);
    }

    static void getFlightAndHotel() throws ResponseException, IOException{
        double cost1 = APITranslator.getExpectedFlightCost(currentUser1.getAirportCode(), location2.getAirportCode(), TEST_DATE);
        System.out.format("Flight Total: %.2f", cost1);
        System.out.println("");

        double hotelPrice1 = APITranslator.getExpectedHotelCost(location2.getCityCode());
        System.out.format("Hotel (Cost per night): %.2f", hotelPrice1);
    }
}
