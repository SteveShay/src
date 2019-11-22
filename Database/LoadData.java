package Database;

import static Enumeration.Enumeration.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Lasted Updated: 11/21/19
 * Loads user data from text file and separates it into individual parts.
 * @authors Stephen Hampson
 */
public class LoadData {
    /**
     * Loads the first line of any text file defined by the stub and name. Used to load user variables and location details.
     *
     * @param _FilepathStub The filepath stub which when added to the unique filename locates the file.
     * @param _name The unique filename to be opened.
     * @return The first line of the file requested as a string.
     * @throws FileNotFoundException
     * @throws IOException
     */
    static String LoadData (String _FilepathStub, String _name) throws FileNotFoundException, IOException{
        //Define the file.
        String filepath = _FilepathStub + _name + TXT;
        File inputFile = new File(filepath);

        //Create the reader then read the first line.
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        String inputLine = br.readLine();

        return inputLine;
    }

    /**
     * Loads the locations filename array from a users file when overwriting/updating a users file. Used to prevent changes in the location list from affecting legacy users.
     *
     * @param _name The users name/filename.
     * @return The users location filename array as a string.
     * @throws FileNotFoundException
     * @throws IOException
     */
    static String LoadUserLocations (String _name) throws FileNotFoundException, IOException {
        String input = "";
        //Define the file.
        String filepath = USER_FILEPATH + _name + TXT;
        File inputFile = new File(filepath);

        //Create the reader and 'burn' the first line to reach the locations array.
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        br.readLine();

        //Read in each line of the array to a string.
        String str;
        while ((str = br.readLine()) != null) {
            input += str + "\n";
        }
        return input;
    }

    /**
     * Checks if a user file exists to validate the user.
     *
     * @param _name The users name/filename.
     * @return A boolean value indicating whether or not the user already exists.
     */
    static boolean checkUser(String _name) {
        String filepath = USER_FILEPATH + _name + TXT;
        File inputFile = new File(filepath);
        return inputFile.exists();
    }
}
