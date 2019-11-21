package Database;

/**
 * Lasted Updated: 10/29/19
 * Connects standard methods to the Database solution currently in use.
 * @author Steve
 */
import static Enumeration.Enumeration.*;
import java.io.IOException;

public class DatabaseTranslator {
    private static final int TEXT = 1;

    private static final int CURRENTUSERDATA = TEXT;
    private static final int CURRENTLOCATIONDATA = TEXT;
    private static final int CURRENTZIPDATA = TEXT;

    public static String getUserData(String _name) throws IOException{
        switch(CURRENTUSERDATA){
            case 1:
                return LoadData.LoadUserData(USER_FILEPATH, _name);
            default:
                System.out.println("No database is selected");
                throw new AssertionError();
        }
    }

    public static String getUserLocations (String _name) throws IOException{
        switch(CURRENTUSERDATA){
            case 1:
                return LoadData.LoadUserLocations(_name);
            default:
                System.out.println("No database is selected");
                throw new AssertionError();
        }
    }

    public static String getLocationData(String _name) throws IOException{
        switch(CURRENTLOCATIONDATA){
            case 1:
                return LoadData.LoadUserData(LOCATION_FILEPATH, _name);
            default:
                System.out.println("No database is selected");
                throw new AssertionError();
        }

    }

    public static double[] getLocationFromZip(int _zip) throws IOException{
        switch (CURRENTZIPDATA) {
            case 1:
                return FindLocationFromZip.getLatandLong(_zip);
            default:
                throw new AssertionError();
        }
    }

    public static void storeUserData(String _name, String _output) throws IOException{
        switch (CURRENTUSERDATA) {
            case 1:
                StoreData.writeFile(_name, _output);
                break;
            default:
                System.out.println("No database is selected");
                throw new AssertionError();
        }
    }
}
