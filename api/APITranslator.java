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
    private static final int DEV = 2;


    private static final int currentFlightAPI = AMADEUS;
    private static final int currentHotelAPI = AMADEUS;
    private static final int currentAirportAPI = AMADEUS;

    public static double getExpectedFlightCost (String _originAirport, String _destinationAirport, String _departureDate) throws ResponseException{
        switch(currentFlightAPI){
            case 1:
                return AmadeusAPI.getExpectedFlightCost(_originAirport, _destinationAirport, _departureDate);
            case 2:
                return DevAPI.getExpectedFlightCost(_originAirport, _destinationAirport, _departureDate);
            default:
                System.out.println("No Flight API is selected");
                throw new AssertionError();
        }
    }
    public static double getExpectedHotelCost (String _citycode) throws ResponseException{
        switch (currentHotelAPI){
            case 1:
                return AmadeusAPI.getExpectedHotelCost(_citycode);
            case 2:
                return DevAPI.getExpectedHotelCost(_citycode);
            default:
                throw new AssertionError();
        }
    }

    public static String getAirportCode (double _latitude, double _longitude) throws ResponseException{
        switch (currentAirportAPI){
            case 1:
                return AmadeusAPI.getAirportCode(_latitude, _longitude);
            default:
                System.out.println("No Airport API selected");
                throw new AssertionError();
        }
    }
}
