package core;

import beans.Trip;
import beans.TripArrTimeComparator;
import beans.TripFlightTimeComparator;
import beans.TripPriceComparator;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author ghh
 * @since 12/01/2017
 * search result is sorted by price in descending order by default. The rest of the sorting is implemented in front end.
 */
public class Sort {

/**
 * This method is used to sort the search result over trip's total price
 * @param ascending boolean value determine ascending sorting
 * @param tripOptions trips needed to be sorted
 */
    public static void sortPrice(boolean ascending, ArrayList<Trip> tripOptions) {

        tripOptions.sort(new TripPriceComparator());

        if (!ascending) {
            Collections.reverse(tripOptions);
        }
    }

    /**
     * This method is used to sort the search result over trip's departure time
     * @param ascending boolean value determine ascending sorting
     * @param tripOptions  trips needed to be sorted
     */
    public static void sortDepTime(boolean ascending, ArrayList<Trip> tripOptions) {
        tripOptions.sort(new TripFlightTimeComparator());
        if (!ascending) {
            Collections.reverse(tripOptions);
        }
    }
    /**
     * This method is used to sort the search result over trip's arrival time
     * @param ascending boolean value determine ascending sorting
     * @param tripOptions  trips needed to be sorted
     */
    public static void sortArrTime(boolean ascending, ArrayList<Trip> tripOptions) {
        tripOptions.sort(new TripArrTimeComparator());
        if (!ascending) {
            Collections.reverse(tripOptions);
        }
    }
    /**
     * This method is used to sort the search result over trip's total flight time
     * @param ascending boolean value determine ascending sorting
     * @param tripOptions  trips needed to be sorted
     */
    public static void sortFlightTime(boolean ascending, ArrayList<Trip> tripOptions) {
        tripOptions.sort(new TripFlightTimeComparator());
        if (!ascending) {
            Collections.reverse(tripOptions);
        }
    }

}
