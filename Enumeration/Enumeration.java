package Enumeration;

/**
 * Lasted Updated: 11/10/19
 * Class for Storing 'most' enumeration variables used project wide.
 * @authors Steve Shay
 */
public class Enumeration {
    //Booleans values as integers.
    public static final int TRUE = 1;
    public static final int FALSE = 0;
    //Amadeus API string inputs.
    public static final String AMADEUS_ID = "L32XhR5nGjRdV3KiGCT58c90NoZ7YAk5";
    public static final String AMADEUS_SECRET = "W1AWTYJzWte788dg";
    public static final String ORIGIN = "origin";
    public static final String DESTINATION = "destination";
    public static final String DEPARTURE_DATE = "departureDate";
    //Keywords for String splits.
    public static final String FLIGHT_SPLIT = "flight-offer";
    public static final String PRICE_SPLIT = "total";
    public static final String TAX_SPLIT = "totalTaxes";
    public static final String INPUT_SPLIT = "\t";
    public static final String RESPONSE_SPLIT = ", ";
    //Array parsing values.
    public static final int ARRAY_START = 0;
    public static final int DATA_ARRAY_NAME = 0;
    public static final int DATA_ARRAY_ZIP = 1;
    public static final int DATA_ARRAY_AIRPORT = 2;
    public static final int DATA_ARRAY_CITY = 3;
    public static final int DATA_ARRAY_RESPONSES = 4;
    public static final int DATA_ARRAY_CATAGORIES = 3;
    public static final int DATA_ARRAY_DESCRIPTION = 4;
    public static final int STRING_ARRAY_START = 1;
    public static final int AVERAGE_SAMPLE_SIZE = 3;
    public static final int SUB_LOWER_BOUND = 3;
    public static final int TAX_UPPER_BOUND = 8;
    //User
    public static final int RESPONSE_ARRAY_SIZE = 26;
    public static final int CATEGORY_ARRAY_SIZE = 5;
    public static final String USER_FILEPATH = "src/UserFiles/";
    public static final String LOCATION_FILEPATH = "src/LocationFiles/";
    public static final String HOTEL_RANGE_FILEPATH = "src/LocationFiles/DevHotelPriceRanges.txt";
    public static final String FLIGHT_RANGE_FILEPATH = "src/LocationFiles/DevFlightPriceRanges.txt";
    public static final String TXT = ".txt";
    

}
