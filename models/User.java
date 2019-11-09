package models;

/**
 * Lasted Updated: 9/30/19
 * User specific data which expands on the base data set.
 * @authors Steve Shay
 */
import static Enumeration.Enumeration.*;

public class User extends BaseData {
    int[] userResponses = new int[ARRAY_SIZE];
    boolean[] categoryResponses = new boolean[CATEGORY_ARRAY_SIZE];

    public User (String _name, int _zipCode, String _airportCode){
        super(_name, _zipCode, _airportCode);
    }

    public User(String _name, int _zipCode, String _airportCode, int[] _responses){
        super(_name, _zipCode, _airportCode);
        this.userResponses = _responses;
    }

    public User(String _name, int _zipCode, String _airportCode, int[] _responses, boolean[] _categories){
        super(_name, _zipCode, _airportCode);
        this.userResponses = _responses;
        this.categoryResponses = _categories;
    }

    public User(String _name, int _zipCode){
        super(_name, _zipCode);
    }

    //======================== GETTERS ========================
    public int[] getUserResponses() {
        return userResponses;
    }

    public int getSingleResponse(int _index){
        return userResponses[_index];
    }

    public boolean[] getCategories(){
        return categoryResponses;
    }

    public boolean getSingleCategory(int _index){
        return categoryResponses[_index];
    }

    //======================== SETTERS ========================
    public void setUserResponses(int[] _userResponses) {
        this.userResponses = _userResponses;
    }

    public void setSingleResponse(int _index, int _value){
        this.userResponses[_index] = _value;
    }

    public void setCategories(boolean[] _categories) {
        this.categoryResponses = _categories;
    }

    public void setSingleCategory(int _index, boolean _value){
        this.categoryResponses[_index] = _value;
    }


}
