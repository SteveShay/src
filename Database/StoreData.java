package Database;

import static Enumeration.Enumeration.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Lasted Updated: 11/10/19
 * Loads user data from text file and separates it into individual parts.
 * @authors Steve Shay
 */
public class StoreData {
    static void writeFile (String _name, String _output) throws FileNotFoundException, IOException{
        String filepath = USER_FILEPATH + _name + TXT;
        FileWriter writer = new FileWriter(filepath);

        writer.write(_output);
        writer.close();
    }
}
