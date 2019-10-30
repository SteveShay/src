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
                return LoadData.LoadFile(USER_FILEPATH, _name);
            default:
                System.out.println("No database is selected");
                throw new AssertionError();
        }
    }

    public static String getLocationData(String _name) throws IOException{
        switch(CURRENTLOCATIONDATA){
            case 1:
                return LoadData.LoadFile(LOCATION_FILEPATH, _name);
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
}
