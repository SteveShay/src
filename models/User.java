package models;

/**
 * Lasted Updated: 11/10/19
 * User specific data which expands on the base data set.
 * @authors Steve Shay
 */
import static Enumeration.Enumeration.*;
import java.util.Random;

public class User extends BaseData {
    int[] userResponses = new int[RESPONSE_ARRAY_SIZE];
    int[] categoryResponses = new int[CATEGORY_ARRAY_SIZE];

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

    public int selectRandomDestination(){
        countTrues();
        int count = 0;
        int returnIndex = 0;
        int max = this.userResponses[25];
        int selection;

        Random r = new Random();
        selection = r.nextInt((max)) + 1;

        for (int i : this.userResponses){
            if (count < selection){
                if (i == TRUE){
                    count++;
                }
                returnIndex++;
            }
        }
        return returnIndex;
    }
    
    public void checkResponseValid(){
        
    }

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
