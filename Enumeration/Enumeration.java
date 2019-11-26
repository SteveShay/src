package Enumeration;

/**
 * Lasted Updated: 11/20/19
 * Class for Storing 'most' enumeration variables used project wide.
 * @authors Stephen Hampson
 */
public class Enumeration {
    //Boolean values as integers.
    public static final int TRUE = 1;
    public static final int FALSE = 0;
    //Amadeus API string inputs.
    public static final String ORIGIN = "origin";
    public static final String DESTINATION = "destination";
    public static final String DEPARTURE_DATE = "departureDate";
    public static final String TEST_DATE = "2020-1-10";
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
    public static final int NUMBER_OF_LOCATIONS = 25;
    public static final int RESPONSE_ARRAY_SIZE = 26;
    public static final int CATEGORY_ARRAY_SIZE = 5;
    //Filepath/Filename values
    public static final String USER_FILEPATH = "src/UserFiles/";
    public static final String LOCATION_FILEPATH = "src/LocationFiles/";
    public static final String HOTEL_RANGE_FILEPATH = "src/LocationFiles/DevHotelPriceRanges.txt";
    public static final String FLIGHT_RANGE_FILEPATH = "src/LocationFiles/DevFlightPriceRanges.txt";
    public static final String TXT = ".txt";
    //Locations indices
    public static final int OUTDOOR_START = 0;
    public static final int OUTDOOR_END = 4;
    public static final int ENTERTAINMENT_START = 5;
    public static final int ENTERTAINMENT_END = 9;
    public static final int EDUCATIONAL_START = 10;
    public static final int EDUCATIONAL_END = 14;
    public static final int CULTURAL_START = 15;
    public static final int CULTURAL_END = 19;
    public static final int HISTORICAL_START = 20;
    public static final int HISTORICAL_END = 4;

    //Current primary Location mapping. Replace string with file name if a location is replaced. Match replacement index with location name.
    public static final String[] CURRENT_LOCATION_FILENAMES =
    {"Location1", "Location2", "Location3", "Location4", "Location5",
    "Location6", "Location7", "Location8", "Location9", "Location10",
    "Location11", "Location12", "Location13", "Location14", "Location15",
    "Location16", "Location17", "Location18", "Location19", "Location20",
    "Location21", "Location22", "Location23", "Location24", "Location25"};

    //Current Locations Names. Replace String with new location name if a location is replaced. Match replacement index with location filename.
    public static final String[] CURRENT_LOCATION_NAMES =
    {"Arcadia National Park", "Anchorage Alaska", "Boulder Colorado", "Grand Canyon", "Yellowstone",
    "Disney World", "Las Vegas", "Mall of America", "Ocean City Beach", "Six Flags Over Georgia",
    "Children's Museum of Indianapolis", "Georgia Aquarium", "San Diego Zoo", "Sea World Orlando", "Smithsonian Museum",
    "Boston", "Honolulu", "New Orleans", "New York", "San Francisco",
    "Alamo", "Alcatraz", "Gettysburg", "Kennedy Space Center", "Washington DC"};
}
