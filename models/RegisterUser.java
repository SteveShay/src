package models;

import Database.DatabaseTranslator;
import api.APITranslator;
import com.amadeus.exceptions.ResponseException;
import java.io.IOException;
import static Enumeration.Enumeration.*;
import java.io.FileWriter;

/**
 * Lasted Updated: 11/08/19
 * Takes data from a new user and creates a file for them.
 * @authors Steve Shay
 */
public class RegisterUser {
    public User newUser (String _name, int _zipCode) throws ResponseException, IOException{

        double[] latAndLong = DatabaseTranslator.getLocationFromZip(_zipCode);
        String aircode = APITranslator.getAirportCode(latAndLong[0], latAndLong[1]);

        return new User(_name, _zipCode, aircode);
    }

    public void storeUser (String _name, int _zipCode, String _airportCode, int[] _responses) throws IOException{
        String filepath = USER_FILEPATH + _name + TXT;
        FileWriter writer = new FileWriter(filepath);
        String responses = _responses.toString();
        String output = _name + INPUT_SPLIT + _zipCode + INPUT_SPLIT + _airportCode, + INPUT_SPLIT + ;
        writer.write
    }

}
