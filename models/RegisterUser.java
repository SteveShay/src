package models;

import Database.DatabaseTranslator;
import static Enumeration.Enumeration.*;
import api.APITranslator;
import com.amadeus.exceptions.ResponseException;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Arrays;

/**
 * Lasted Updated: 11/08/19
 * Takes data from a new user and creates a file for them.
 * @authors Steve Shay
 */
public class RegisterUser {
    public static User newUser (String _name, int _zipCode) throws ResponseException, IOException{

        double[] latAndLong = DatabaseTranslator.getLocationFromZip(_zipCode);
        String aircode = APITranslator.getAirportCode(latAndLong[0], latAndLong[1]);

        return new User(_name, _zipCode, aircode);
    }

    public static void storeUser (String _name, int _zipCode, String _airportCode, int[]_catagories, int[] _responses) throws IOException {
        String filepath = "src/UserFiles/" + _name + TXT;
        FileWriter writer = new FileWriter(filepath);
        String catagories = Arrays.toString(_catagories);
        String responses = Arrays.toString(_responses);
        String output = _name + INPUT_SPLIT + _zipCode + INPUT_SPLIT + _airportCode + INPUT_SPLIT + catagories.substring(1, catagories.length() - 1) + INPUT_SPLIT + responses.substring(1, responses.length() - 1);
        writer.write(output);
        writer.close();
    }
}
