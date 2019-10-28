package api;

/**
 * Lasted Updated: 9/25/19
 * API translation prototypes which will eventually be transfered to the final API translators.
 * @authors Steve Shay
 */

import static Enumeration.Enumeration.*;
import com.amadeus.Amadeus;
import com.amadeus.Params;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.referenceData.Locations;
import com.amadeus.resources.FlightOffer;
import com.amadeus.resources.HotelOffer;
import com.amadeus.resources.Location;

import models.User;
import models.VacationLocation;

public class apiPrototype {

    static double getExpectedFlightCost (User _user, VacationLocation _location, String _departureDate) throws ResponseException {
        String originAirport = _user.getAirportCode();
        String destinationAirport = _location.getAirportCode();

        Amadeus amadeus = Amadeus
            .builder(AMADEUS_ID, AMADEUS_SECRET)
            .build();

        FlightOffer[] flightOffers = amadeus.shopping.flightOffers.get(Params
            .with(ORIGIN, originAirport)
            .and(DESTINATION, destinationAirport)
            .and(DEPARTURE_DATE, _departureDate));

        String csv = flightOffers[0].getResponse().getBody();

        double projectedFlightCost = findFlightAverage(csv, FLIGHT_SPLIT);

        System.out.println(projectedFlightCost);

        System.out.println("");

        System.out.println(flightOffers[0].getResponse().getBody());
        return projectedFlightCost;
    }
    /* FUCK THIS SECTION
     * This section/api call doesn't work in the test environment due to no available offers.
     *I will be seeking a new api for hotel pricing.
     */
    /*static void getHotels () throws ResponseException {
        //String hotelCityCode = _location.getCityCode();

        Amadeus amadeus = Amadeus
            .builder(AMADEUS_ID, AMADEUS_SECRET)
            .build();

        HotelOffer[] offers = amadeus.shopping.hotelOffers.get(Params
            .with("cityCode", "MAD")
            .and("checkInDate", "2019-12-22")
            .and("checkOutDate", "2019-12-23"));
        if (offers[0].getResponse().getStatusCode() != 200) {
            System.out.println("Wrong status code for Hotel 1st endpoint: " + offers[0].getResponse().getStatusCode());
            System.exit(-1);
        }
        for (int i = 0; i < offers.length - 1; i++) {
            System.out.println(offers[i].getOffers()[0].getId() + " " + offers[i].getHotel());
        }

        //String csv = hotelOffers[0].getResponse().getBody();

        //System.out.println(hotelOffers[0]);
    }*/

    public static double findFlightAverage (String _apiResponse, String _splitType){
        String[] values = _apiResponse.split(_splitType);
        double totalPricing = 0;

        for (int i = STRING_ARRAY_START; i < AVERAGE_SAMPLE_SIZE + 1; i++){
            String iFlight = values[i].toString();
            String[] prices = iFlight.split(PRICE_SPLIT);
            String price = prices[STRING_ARRAY_START].toString();
            price = price.substring(SUB_LOWER_BOUND,price.length() - 3);
            System.out.println(price);
            String[] taxes = iFlight.split(TAX_SPLIT);
            String tax = taxes[STRING_ARRAY_START].toString();
            tax = tax.substring(SUB_LOWER_BOUND, TAX_UPPER_BOUND);
            System.out.println(tax);
            double subTotal = Double.parseDouble(price) + Double.parseDouble(tax);
            totalPricing += subTotal;
        }
        double average = totalPricing / AVERAGE_SAMPLE_SIZE;
        System.out.println(totalPricing);
        System.out.println(average);

        return average;
    }

    public static void getHotels() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
