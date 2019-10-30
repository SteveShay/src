package Testing;

import com.amadeus.exceptions.ResponseException;

/**
 *
 * @author Steve Shay
 */
public class Testing {
    public static void main(String[] args) throws ResponseException{
        //api.apiPrototype.getExpectedFlightCost("GSO", "JFK", "2019-12-22");
        apiPrototype.getExpectedHotelCost("NYC");






        /*OLD TESTS
        System.out.println("");
        System.out.println(JamesTest.getName());
        System.out.println(JamesTest.getZipCode());
        System.out.println(JamesTest.getAirportCode());

        System.out.print(JamesTest.getSingleResponse(3));
        System.out.print(" ");
        System.out.print(JamesTest.getSingleResponse(20));
        System.out.print(" ");
        System.out.println(JamesTest.getSingleResponse(25));
        System.out.print(" ");
        //test integer attribute
        System.out.println(JamesTest.getSingleResponse(3)+JamesTest.getSingleResponse(20)+JamesTest.getSingleResponse(25));
        */
    }
}
