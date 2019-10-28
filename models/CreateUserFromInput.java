package models;

import static Enumeration.Enumeration.*;

/**
 * Lasted Updated: 9/30/19
 * Class to split input string into individual pieces and create a user object.
 * @authors Steve Shay
 */
public class CreateUserFromInput {
    public static User createUser(String[] _input){

        String name = _input[DATA_ARRAY_NAME];
        int zip = Integer.parseInt(_input[DATA_ARRAY_ZIP]);
        String airport = _input[DATA_ARRAY_AIRPORT];
        String response = _input[DATA_ARRAY_RESPONSES];
        String[] stringResponses = response.split(RESPONSE_SPLIT);
        int[] intResponses = parseResponses(stringResponses);

        return new User(name, zip, airport, intResponses);
    }

    private static int[] parseResponses(String[] _responseInput){
        int[] intResponses = new int[ARRAY_SIZE];

        for (int i = ARRAY_START; i < ARRAY_SIZE; i++){
            intResponses[i] = Integer.parseInt(_responseInput[i]);
        }
        return intResponses;
    }
}
