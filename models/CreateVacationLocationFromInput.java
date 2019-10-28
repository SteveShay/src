package models;

import static Enumeration.Enumeration.*;
/**
 * Last Updated: 9/30/19
 * Class to split input string into individual pieces and create a VLocation object.
 * @author Steve
 */
public class CreateVacationLocationFromInput {
    public static VacationLocation createLocation(String[] _input){
        String name = _input[DATA_ARRAY_NAME];
        int zip = Integer.parseInt(_input[DATA_ARRAY_ZIP]);
        String airport = _input[DATA_ARRAY_AIRPORT];
        String cityCode = _input[DATA_ARRAY_CITY];
        String description = _input[DATA_ARRAY_DESCRIPTION];

        return new VacationLocation(name, zip, airport, cityCode, description);
    }
}
