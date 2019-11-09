package models;

import Database.DatabaseTranslator;
import api.APITranslator;
import com.amadeus.exceptions.ResponseException;
import java.io.IOException;

/**
 * Lasted Updated: 10/29/19
 * Creates a new User.
 * @author Steve
 */
public class RegisterUser {
    public static User createNewUser(String _name, int _zipCode) throws IOException, ResponseException{
        User newUser = new User(_name, _zipCode);
        double[] latAndLong = DatabaseTranslator.getLocationFromZip(_zipCode);
        String airportCode = APITranslator.getAirportCode(latAndLong[0], latAndLong[1]);
        newUser.setAirportCode(airportCode);
        
        
    }
}
