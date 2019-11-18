package api;

import static Enumeration.Enumeration.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Lasted Updated: 10/29/19
 * FOR DEVELOPMENT USE ONLY
 * Returns standard results to API requests to reduce main API usage during development.
 * @author Steve
 */
public class DevAPI {
    static double getExpectedFlightCost (String _originAirport, String _destinationAirport, String _departureDate) throws IOException{
        double averageby = 5.00;
        double total = 0;

        double[] flightRange = getRange(FLIGHT_RANGE_FILEPATH, _destinationAirport);
        double base = flightRange[0];
        double range = flightRange[1];

        for(int i = 0; i < averageby; i++){
            total += (base + (Math.random() * range));
        }

        return total / averageby;
    }
    static double getExpectedHotelCost(String _citycode) throws IOException{
        double averageby = 5.00;
        double total = 0;

        double[] hotelRange = getRange(HOTEL_RANGE_FILEPATH, _citycode);
        double base = hotelRange[0];
        double range = hotelRange[1];

        for(int i = 0; i < averageby; i++){
            total += (base + (Math.random() * range));
        }

        return total / averageby;
    }

    static String getAirportCode (double _latitude, double _longitude){
        return "GSO";
    }

    private static double[] getRange(String _filepath, String _code) throws FileNotFoundException, IOException{
        String[] input = null;
        double[] result = new double[2];

        File inputFile = new File(_filepath);
        BufferedReader br = new BufferedReader(new FileReader(inputFile));

        String str;
        while ((str = br.readLine()) != null){
            input = str.split("\t");
            if (_code.equals(input[0])){
                String base = input[1];
                String range = input[2];

                result[0] = Double.parseDouble(base);
                result[1] = Double.parseDouble(range);
            }
        }
        return result;
    }
}
