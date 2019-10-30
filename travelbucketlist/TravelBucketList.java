package travelbucketlist;

/**
 * Lasted Updated: 9/30/19
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
import models.CreateUserFromInput;
import models.CreateVacationLocationFromInput;

public class TravelBucketList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ResponseException {
        String date = "2019-12-22";
        User bob = new User("Bob", 27284, "GSO");
        VacationLocation NY = new VacationLocation("New York", 11430, "JFK", "NYC", "Test Description");

        //Test API calls for flights.
        try{
            APITranslator.getExpectedFlightCost(bob.getAirportCode(), NY.getAirportCode(), "2019-12-22");
        }
        catch(Exception e){
            System.out.println("error");

        }

        //Test loading user from file.
        String userFileData = DatabaseTranslator.getUserData("James Bond");
        String[] userData = userFileData.split(INPUT_SPLIT);
        String locationFileData = DatabaseTranslator.getLocationData("New York City");
        String[] locationData = locationFileData.split(INPUT_SPLIT);

        //Test User object data load and getters
        User JamesTest = CreateUserFromInput.createUser(userData);
        VacationLocation NYC = CreateVacationLocationFromInput.createLocation(locationData);

        try{
            double cost = APITranslator.getExpectedFlightCost(JamesTest.getAirportCode(), NYC.getAirportCode(), "2019-12-22");
            System.out.format("response: %.2f", cost);
            System.out.println("");
        }
        catch(Exception e){
            System.out.println("error");
        }

        System.out.println("");

        double hotelPrice = APITranslator.getExpectedHotelCost("NYC");
        System.out.format("response: %.2f", hotelPrice);
        System.out.println("");

        double[] latAndLong = DatabaseTranslator.getLocationFromZip(JamesTest.getZipCode());
        System.out.println(latAndLong[0]);
        System.out.println(latAndLong[1]);

        String aircode = APITranslator.getAirportCode(latAndLong[0], latAndLong[1]);
        System.out.println("Walkertown: " + aircode);
    }
}
