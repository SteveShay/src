package api;

/**
 * Lasted Updated: 10/29/19
 * API translation prototypes which will eventually be transfered to the final API translators.
 * @authors Steve Shay
 */

import static Enumeration.Enumeration.*;
import com.amadeus.Amadeus;
import com.amadeus.Params;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOffer;
import com.amadeus.resources.HotelOffer;
import com.amadeus.resources.Location;

public class AmadeusAPI {

    static double getExpectedFlightCost (String _originAirport, String _destinationAirport, String _departureDate) throws ResponseException {
        double total = 0;
        int count = 1;

        Amadeus amadeus = Amadeus
            .builder(AMADEUS_ID, AMADEUS_SECRET)
            .build();

        FlightOffer[] flightOffers = amadeus.shopping.flightOffers.get(Params
            .with(ORIGIN, _originAirport)
            .and(DESTINATION, _destinationAirport)
            .and(DEPARTURE_DATE, _departureDate));
        
        try {
            total += flightOffers[0].getOfferItems()[0].getPrice().getTotal();
        }
        catch(Exception e){
            return APITranslator.falloverFlightAPI(_originAirport, _destinationAirport, _departureDate);
        }
        try{
            for (int i = 1; i < 5; i++) {
                total += flightOffers[i].getOfferItems()[0].getPrice().getTotal();
                count++;
            }
        }
        catch(Exception e){
            System.out.println("Only " + count + " hotel offer(s).");
        }

        System.out.println("Flight Total: " + total/count);
        return total/3;
    }

    static double getExpectedHotelCost(String _citycode) throws ResponseException{
        double total = 0;
        int count = 1;

        Amadeus amadeus = Amadeus
            .builder(AMADEUS_ID, AMADEUS_SECRET)
            .build();

        HotelOffer[] offers = amadeus.shopping.hotelOffers.get(Params.with("cityCode", _citycode));
        try {
            total += Double.parseDouble(offers[0].getOffers()[0].getPrice().getTotal());
        }
        catch(Exception e){
            return APITranslator.falloverHotelAPI(_citycode);
        }
        try{
            for (int i = 1; i < 5; i++) {
                total += Double.parseDouble(offers[i].getOffers()[0].getPrice().getTotal());
                count++;
            }
        }
        catch(Exception e){
            System.out.println("Only " + count + " hotel offer(s).");
        }

        return total/count;
    }

    static String getAirportCode(double _latitude, double _longitude) throws ResponseException{
        Amadeus amadeus = Amadeus
            .builder(AMADEUS_ID, AMADEUS_SECRET)
            .build();
        Location[] locations = amadeus.referenceData.locations.airports.get(Params
            .with("latitude", _latitude)
            .and("longitude", _longitude));
        return locations[0].getIataCode();
    }

    //Depricated code
    /*public static double findFlightAverage (String _apiResponse, String _splitType){
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
    }*/

}
