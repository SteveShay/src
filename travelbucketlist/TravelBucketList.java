package travelbucketlist;

/**
 * Lasted Updated: 9/30/19
 * Project main class. Currently being used as a testing ground.
 * @authors Steve Shay
 */
import java.io.IOException;
import models.LoadData;
import models.VacationLocation;
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
            APITranslator.getExpectedFlightCost(bob, NY, "2019-12-22");
        }
        catch(Exception e){
            System.out.println("error");

        }

        //Test loading user from file.
        String userFileData = LoadData.userLoadFile("James Bond");
        String[] userData = userFileData.split(INPUT_SPLIT);
        String locationFileData = LoadData.locationLoadFile("New York City");
        String[] locationData = locationFileData.split(INPUT_SPLIT);

        //Test User object data load and getters
        User JamesTest = CreateUserFromInput.createUser(userData);
        VacationLocation NYC = CreateVacationLocationFromInput.createLocation(locationData);
        System.out.println("");
        System.out.println(JamesTest.getName());
        System.out.println(JamesTest.getZipCode());
        System.out.println(JamesTest.getAirportCode());

        //test user response load to array
        System.out.print(JamesTest.getSingleResponse(3));
        System.out.print(" ");
        System.out.print(JamesTest.getSingleResponse(20));
        System.out.print(" ");
        System.out.println(JamesTest.getSingleResponse(25));
        System.out.print(" ");
        //test integer attribute
        System.out.println(JamesTest.getSingleResponse(3)+JamesTest.getSingleResponse(20)+JamesTest.getSingleResponse(25));

        try{
            double cost = APITranslator.getExpectedFlightCost(JamesTest, NYC, "2019-12-22");
            System.out.println(cost);
        }
        catch(Exception e){
            System.out.println("error");
        }
        /*This call doesn't work properly in the api test environment.
        I will be seeking a new option for hotel pricing
        */
        /*try{
            apiPrototype.getHotels();
        }
        catch(ResponseException e){
            System.out.println(e);
        }*/
    }
}
