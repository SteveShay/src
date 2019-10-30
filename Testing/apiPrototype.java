package Testing;

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
    public static void getExpectedFlightCost (String _originAirport, String _destinationAirport, String _departureDate) throws ResponseException {
        Amadeus amadeus = Amadeus
            .builder(AMADEUS_ID, AMADEUS_SECRET)
            .build();

        FlightOffer[] flightOffers = amadeus.shopping.flightOffers.get(Params
            .with(ORIGIN, _originAirport)
            .and(DESTINATION, _destinationAirport)
            .and(DEPARTURE_DATE, _departureDate));

        for (int i = 0; i < 3; i++) {
            System.out.println(flightOffers[i].getOfferItems()[0].getPrice().getTotal());
        }
    }
    public static void getExpectedHotelCost(String _citycode) throws ResponseException{
        double total = 0;

        Amadeus amadeus = Amadeus
            .builder(AMADEUS_ID, AMADEUS_SECRET)
            .build();

        HotelOffer[] offers = amadeus.shopping.hotelOffers.get(Params.with("cityCode", "MAD"));
        for (int i = 0; i < 3; i++) {
            total += Double.parseDouble(offers[i].getOffers()[0].getPrice().getTotal());
        }
        System.out.println("Hotel Total: " + total/3);
    }
}
