package util;

import java.util.ArrayList;

import static util.Saps.TEAM_NAME;

/**
 * @author Tomas 
 * @since 2017/11/01
 * @version 2.0
 */
public class QueryFactory {
    /**
     * Return a query string that can be passed to HTTP URL to request list of airports
     *
     * @return the query String which can be appended to URL to form HTTP GET request
     */
    static String getAirports() {
        return "?team=" + TEAM_NAME + "&action=list&list_type=airports";
    }

    /**
     * Lock the server database so updates can be written
     *
     * @return the String written to HTTP POST to lock server database
     */
    static String lock() {
        return "team=" + TEAM_NAME + "&action=lockDB";
    }

    /**
     * Unlock the server database after updates are written
     *
     * @return the String written to the HTTP POST to unlock server database
     */
    static String unlock() {
        return "team=" + TEAM_NAME + "&action=unlockDB";
    }

    /**
     * Return a query string of departure flights from an airport at a date
     *
     * @param date the departure date
     * @param code the code of the airport
     * @return the query string of get departure flights from an airport at a date
     */
    static String getDepFlights(String date, String code) {
        return "?team=" + TEAM_NAME + "&action=list&list_type=departing&airport=" + code + "&day=" + date;
    }

    /**
     * Return a query string of arriving flights at an airport at a date
     *
     * @param date the arrival date
     * @param code the code of airport
     * @return query string of get arrival flights at airport at a date
     */
    static String getArrFlights(String date, String code) {
        return "?team=" + TEAM_NAME + "&action=list&list_type=departing&airport=" + code + "&day=" + date;
    }

    /**
     * Takes two arraylists of strings as input, generate the query flight xml data to order seats on some specific flights
     * Return query string of getting all of the airplanes
     *
     * @return the query string
     */
    static String getAirplanes() {
        return "?team=" + TEAM_NAME + "&action=list&list_type=airplanes";
    }
/**
 * 
 * @param flightNumbers flightNumbers is a specific number of flight object we defined in the
 * beans' Flight which can used to reserve the specific trip
 * @param seatTypes eatTypes  is the user's seat preference coach or first class.
 * @return booked flights
 */
    static String reserveSeats(ArrayList<String> flightNumbers, ArrayList<String> seatTypes) {
        StringBuilder result = new StringBuilder();
        result.append("team=" + TEAM_NAME + "&action=buyTickets&flightData=<Flights>");
        int i = 0;
        for (String flightNumber : flightNumbers) {
            result.append("<Flight number=\"").append(flightNumber).append("\" seating=\"").append(seatTypes.get(i)).append("\"/>");
            i++;
        }
        result.append("</Flights>");
        return result.toString();
    }
}
