package api;

import com.amadeus.exceptions.ResponseException;
import models.User;
import models.VacationLocation;

/**
 * Connects standard methods to the API currently in use.
 * @author Steve
 */
public class APITranslator {
    private static final int AMADEUS = 1;

    private static final int currentFlightAPI = AMADEUS;
    private static final int currentHotelAPI = AMADEUS;

    public static double getExpectedFlightCost (User _user, VacationLocation _destination,String _departure) throws ResponseException{
        switch(currentFlightAPI){
            case 1:
                return apiPrototype.getExpectedFlightCost(_user, _destination, _departure);
            default:
                System.out.println("No Flight API is selected");
                throw new AssertionError();

        }
    }
    public static void getExpectedHotelCost (){
        switch (currentHotelAPI) {
            case 1:
                apiPrototype.getHotels();
                break;
            default:
                throw new AssertionError();
        }
    }
}
