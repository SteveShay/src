package models;

/**
 * Lasted Updated: 9/30/19
 VacationLocation specific data which expands on the base data set.
 * @authors Steve Shay
 */
public class VacationLocation extends BaseData {
    String cityCode;
    String description;

    public VacationLocation (String _name, int _zipCode, String _airportCode, String _cityCode, String _description){
        super(_name, _zipCode, _airportCode);
        this.cityCode = _cityCode;
        this.description = _description;
    }

    //======================== GETTERS ========================
    public String getCityCode() {
        return this.cityCode;
    }

    public String getDescription() {
        return this.description;
    }

    //======================== SETTERS ========================
    public void setCityCode(String _cityCode) {
        this.cityCode = _cityCode;
    }
    
    public void setDescription(String _description){
        this.description = _description;
    }
}
