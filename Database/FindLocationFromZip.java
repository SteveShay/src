package Database;

import static Enumeration.Enumeration.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Lasted Updated: 10/29/19
 * Searches Zip.txt for the provided zip code and returns the latitude and longitude.
 * @authors Steve Shay
 */
class FindLocationFromZip{
    static double[] getLatandLong(int _zip) throws FileNotFoundException, IOException{
        String[] input;
        double[] result = new double[2];
        Boolean found = false;

        String filepath = LOCATION_FILEPATH + "Zip" + TXT;
        File inputFile = new File(filepath);
        BufferedReader br = new BufferedReader(new FileReader(inputFile));

        String str;
        while ((str = br.readLine()) != null){
            input = str.split(";");
            int intInput = Integer.parseInt(input[0]);
            if (_zip == intInput){
                found = true;

                String strLat = input[3];
                String strLong = input[4];

                result[0] = Double.parseDouble(strLat);
                result[1] = Double.parseDouble(strLong);
            }
        }
        if (found){
           return result;
        }
        else{
            throw new IllegalArgumentException();
        }
    }
}

