package api;

import com.amadeus.exceptions.ResponseException;
import java.io.IOException;


/**
 * Lasted Updated: 11/13/19
 * Connects standard methods to the API currently in use.
 * @author Steve
 */
public class APITranslator {
    private static final int AMADEUS = 1;
    private static final int DEV = 2;


    private static final int CURRENT_FLIGHT_API = DEV;
    private static final int CURRENT_HOTEL_API = DEV;
    private static final int CURRENT_AIRPORT_API = AMADEUS;

    public static double getExpectedFlightCost (String _originAirport, String _destinationAirport, String _departureDate) throws ResponseException, IOException{
        switch(CURRENT_FLIGHT_API){
            case 1:
                return AmadeusAPI.getExpectedFlightCost(_originAirport, _destinationAirport, _departureDate);
            case 2:
                return DevAPI.getExpectedFlightCost(_originAirport, _destinationAirport, _departureDate);
            default:
                System.out.println("No Flight API is selected");
                throw new AssertionError();
        }
    }

    public static double falloverFlightAPI (String _originAirport, String _destinationAirport, String _departureDate) throws IOException{
        System.out.println("No Flights Found. Using Dev estimates.");
        return DevAPI.getExpectedFlightCost(_originAirport, _destinationAirport, _departureDate);
    }

    public static double getExpectedHotelCost (String _citycode) throws ResponseException, IOException{
        switch (CURRENT_HOTEL_API){
            case 1:
                return AmadeusAPI.getExpectedHotelCost(_citycode);
            case 2:
                return DevAPI.getExpectedHotelCost(_citycode);
            default:
                throw new AssertionError();
        }
    }

    public static double falloverHotelAPI (String _cityCode) throws IOException{
        System.out.println("No Hotels Found.");
        return DevAPI.getExpectedHotelCost(_cityCode);
    }

    public static String getAirportCode (double _latitude, double _longitude) throws ResponseException{
        switch (CURRENT_AIRPORT_API){
            case 1:
                return AmadeusAPI.getAirportCode(_latitude, _longitude);
            case 2:
                return DevAPI.getAirportCode(_latitude, _longitude);
            default:
                System.out.println("No Airport API selected");
                throw new AssertionError();
        }
    }
}
