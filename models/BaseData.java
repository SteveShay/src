package models;

/**
 * Lasted Updated: 9/25/19
 * Base data used by both users and locations.
 * @authors Steve Shay
 */

class BaseData {
    private String name;
    private String airportCode;
    private int zipCode;

    BaseData(String _name, int _zipCode){
        this.name = _name;
        this.zipCode = _zipCode;
    }

    BaseData(String _name, int _zipCode, String _airportCode){
        this.name = _name;
        this.zipCode = _zipCode;
        this.airportCode = _airportCode;
    }

    //======================== GETTERS ========================
    public String getName() {
        return this.name;
    }

    public String getAirportCode() {
        return this.airportCode;
    }

    public int getZipCode() {
        return this.zipCode;
    }
    //======================== SETTERS ========================
    public void setName(String _name) {
        this.name = _name;
    }

    public void setAirportCode(String _airportCode) {
        this.airportCode = _airportCode;
    }

    public void setZipCode(int _zipCode) {
        this.zipCode = _zipCode;
    }
}
