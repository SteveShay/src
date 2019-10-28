package models;

/**
 * Lasted Updated: 9/30/19
 * User specific data which expands on the base data set.
 * @authors Steve Shay
 */
import static Enumeration.Enumeration.*;

public class User extends BaseData {
    int[] userResponses = new int[ARRAY_SIZE];

    public User (String _name, int _zipCode, String _airportCode){
        super(_name, _zipCode, _airportCode);
    }

    public User(String _name, int _zipCode, String _airportCode, int[] _responses){
        super(_name, _zipCode, _airportCode);
        this.userResponses = _responses;
    }

    //======================== GETTERS ========================
    public int[] getUserResponses() {
        return userResponses;
    }

    public int getSingleResponse(int _index){
        return userResponses[_index];
    }

    //======================== SETTERS ========================
    public void setUserResponses(int[] _userResponses) {
        this.userResponses = _userResponses;
    }

    public void setSingleResponse(int _index, int _value){
        this.userResponses[_index] = _value;
    }


}
