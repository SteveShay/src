package Database;

import static Enumeration.Enumeration.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Lasted Updated: 9/26/19
 * Loads user data from text file and separates it into individual parts.
 * @authors Steve Shay
 */
public class LoadData {
    static String LoadFile (String _FilepathStub, String _name) throws FileNotFoundException, IOException{
        String filepath = _FilepathStub + _name + TXT;
        File inputFile = new File(filepath);

        BufferedReader br = new BufferedReader(new FileReader(inputFile));

        String inputLine = br.readLine();

        return inputLine;
    }
}
