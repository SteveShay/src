package models;

/**
 * Lasted Updated: 11/18/19
 * User specific data which expands on the base data set.
 * @authors Steve Shay
 */
import static Enumeration.Enumeration.*;
import java.util.Random;

public class User extends BaseData {
    //Static random declaration for two methods below.
    static Random r = new Random();

    //Create the two arrays unique to users.
    int[] userResponses = new int[RESPONSE_ARRAY_SIZE];
    int[] categoryResponses = new int[CATEGORY_ARRAY_SIZE];

    //All user constructors.
    public User (String _name, int _zipCode, String _airportCode){
        super(_name, _zipCode, _airportCode);
    }

    public User(String _name, int _zipCode, String _airportCode, int[] _responses){
        super(_name, _zipCode, _airportCode);
        this.userResponses = _responses;
    }

    public User(String _name, int _zipCode, String _airportCode, int[] _categories, int[] _responses){
        super(_name, _zipCode, _airportCode);
        this.userResponses = _responses;
        this.categoryResponses = _categories;
    }

    public User(String _name, int _zipCode){
        super(_name, _zipCode);
    }

    //Select a random destination based on the users responses about their interests.
    public int selectRandomDestination(){
        //Update the ammount of locations the user expressed interest in.
        countTrues();
        //Keeps track of how many true responses have been passed.
        int count = 0;
        //Keeps track of the current index for return.
        int returnIndex = 0;
        //Pull number of true responses from the final index in the array.
        int max = this.userResponses[25];
        int selection;

        //Select a random integer from 1 to the number of true responses. (inclusive)
        selection = r.nextInt((max)) + 1;

        //Loop through all values in the array.
        for (int i : this.userResponses){
            //While the selected destination based on number of true responses hasn't been passed.
            if (count < selection){
                //If current index is true increment count.
                if (i == TRUE){
                    count++;
                }
                //Increment return index to current .
                returnIndex++;
            }
        }
        //End by returning the 'returnIndex'.
        return returnIndex;
    }

    //Check to make sure the user didn't answer false to all locations.
    public void checkResponseValid(){
        countTrues();
        int selection;
        int count = 0;

        //If they did answer false to all.....
        if (this.userResponses[25] == 0){
            //Select five locations from the whole for them.
            while (count < 5){
                selection = r.nextInt((NUMBER_OF_LOCATIONS) + 1);
                if (this.userResponses[selection] == FALSE){
                    this.userResponses[selection] = TRUE;
                    count++;
                }
            }
        }
    }

    //Loop through the entire array and update the final index with how many times they responded true.
    private void countTrues(){
        int count = 0;
        for (int i = 0; i < this.userResponses.length - 2; i++){
            if (this.userResponses[i] == TRUE){
                count ++;
            }
        }
        this.userResponses[25] = count;
    }

    //======================== GETTERS ========================
    public int[] getUserResponses() {
        return this.userResponses;
    }

    public int getSingleResponse(int _index){
        return this.userResponses[_index];
    }

    public int[] getCategories(){
        return this.categoryResponses;
    }

    public int getSingleCategory(int _index){
        return this.categoryResponses[_index];
    }

    //======================== SETTERS ========================
    public void setUserResponses(int[] _userResponses) {
        this.userResponses = _userResponses;
    }

    public void setSingleResponse(int _index, int _value){
        this.userResponses[_index] = _value;
    }

    public void setCategories(int[] _categories) {
        this.categoryResponses = _categories;
    }

    public void setSingleCategory(int _index, int _value){
        this.categoryResponses[_index] = _value;
    }
}
