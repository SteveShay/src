package models;

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
    public static String userLoadFile (String _name) throws FileNotFoundException, IOException{
        String filepath = USER_FILEPATH + _name + TXT;
        File inputFile = new File(filepath);

        BufferedReader br = new BufferedReader(new FileReader(inputFile));

        String inputLine = br.readLine();

        return inputLine;
    }

    public static String locationLoadFile (String _name) throws FileNotFoundException, IOException{
        String filepath = LOCATION_FILEPATH + _name + TXT;
        File inputFile = new File(filepath);

        BufferedReader br = new BufferedReader(new FileReader(inputFile));

        String inputLine = br.readLine();

        return inputLine;
    }
}
