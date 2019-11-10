package api;

/**
 * Lasted Updated: 10/29/19
 * FOR DEVELOPMENT USE ONLY
 * Returns standard results to API requests to reduce main API usage during development.
 * @author Steve
 */
public class DevAPI {
    static double getExpectedFlightCost (String _originAirport, String _destinationAirport, String _departureDate){
        return 300.00;
    }
    static double getExpectedHotelCost(String _citycode){
        return 69.69;
    }
    
    static String getAirportCode (double _latitude, double _longitude){
        return "GSO";
    }
}
