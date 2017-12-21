package beans;

import util.HttpUtil;
import util.TimezoneMapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * This class stores values information to a single flight from one airport to another. 
 * Attributes are accessed via get and set methods.
 *  
 * @author Tomas
 * @version 2.0
 * @since 2017-09-20
 *
 */
public class Flight {
	/**
	 * Attributes describing a flight
	 */
    private Airplane airplane;
    private int flightTime;
    private String flightNumber;
    private String depAirportCode;
    private String depTime;
    private String localDepTime;
    private String localArrTime;
    private String arrAirportCode;
    private String arrTime;
    private String firstClassPrice;
    private String coachClassPrice;
    private int firstClassBooked;
    private int coachClassBooked;

    public Flight() {
        airplane = new Airplane();
        flightTime = 0;
        flightNumber = "";
        depAirportCode = "";
        arrAirportCode = "";
        depTime = "";
        arrTime = "";
        firstClassPrice = "";
        coachClassPrice = "";
        firstClassBooked = 0;
        coachClassBooked = 0;
    }
    /**
	 * Determine if a Flight is reasonably valid
	 * 
	 * @return true if the Flight instance is reasonable valid
	 */
    public boolean isValid() {
        return flightTime >= 0 && !firstClassPrice.equals("") && !coachClassPrice.equals("") && !flightNumber.equals("");
    }

    public Flight(String planeName, int flightTime, String flightNumber, String depAirportCode
            , String depTime, String arrAirportCode, String arrTime, String firstClassPrice, String coachClassPrice
            , int firstClassBooked, int coachClassBooked) {
        airplane = new Airplane(planeName);
        this.flightTime = flightTime;
        this.flightNumber = flightNumber;
        this.depAirportCode = depAirportCode;
        this.depTime = depTime;
        this.arrAirportCode = arrAirportCode;
        this.arrTime = arrTime;
        this.firstClassPrice = firstClassPrice;
        this.coachClassPrice = coachClassPrice;
        this.firstClassBooked = firstClassBooked;
        this.coachClassBooked = coachClassBooked;

    }

    public String toString() {
        return flightNumber + " " + airplane.getName() + " " + depAirportCode + " " + depTime + " " + arrAirportCode
                + " " + arrTime + " " + firstClassBooked + " " + firstClassPrice + " " + coachClassBooked
                + " " + coachClassPrice;
    }
    /**
	 * @return the flightNumber
	 */
    public String getFlightNumber() {
        return flightNumber;
    }
    /**
	 * @param flightNumber the flightNumbe to set
	 */
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
    /**
   	 * @return the airplane
   	 */
    public Airplane getAirplane() {
        return airplane;
    }
    /**
	 * @param airplane the airplane to set
	 */
    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }
    /**
   	 * @return the flightTime
   	 */
    public int getFlightTime() {
        return flightTime;
    }
    
    public String getLocalDepTime() {
        return localDepTime;
    }

    public String getLocalArrTime() {
        return localArrTime;
    }
    /**
	 * @param flightTime the flightTime to set
	 */
    public void setFlightTime(int flightTime) {
        this.flightTime = flightTime;
    }
    /**
   	 * @return the depAirportCode
   	 */
    public String getDepAirportCode() {
        return depAirportCode;
    }
    /**
   	 * @param depAirportCode the depAirportCode to set
   	 */
    public void setDepAirportCode(String depAirportCode) {
        this.depAirportCode = depAirportCode;
    }
    /**
   	 * @return the depTime
   	 */
    public String getDepTime() {
        return depTime;
    }
    /**
   	 * @param depTime the depTime to set
   	 */
    public void setDepTime(String depTime) {
        this.depTime = depTime;
    }
    /**
   	 * @return the arrAirportCode
   	 */
    public String getArrAirportCode() {
        return arrAirportCode;
    }
    /**
   	 * @param arrAirportCode the arrAirportCode to set
   	 */
    public void setArrAirportCode(String arrAirportCode) {
        this.arrAirportCode = arrAirportCode;
    }
    /**
   	 * @return the arrTime
   	 */
    public String getArrTime() {
        return arrTime;
    }
    /**
   	 * @param arrTime the arrTime to set
   	 */
    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }
    /**
   	 * @return the firstClassPrice
   	 */
    public String getFirstClassPrice() {
        return firstClassPrice;
    }
    /**
   	 * @param firstClassPrice the firstClassPrice to set
   	 */
    public void setFirstClassPrice(String firstClassPrice) {
        this.firstClassPrice = firstClassPrice;
    }
    /**
   	 * @return the coachClassPrice
   	 */
    public String getCoachClassPrice() {
        return coachClassPrice;
    }
    /**
   	 * @param coachClassPrice the coachClassPrice to set
   	 */
    public void setCoachClassPrice(String coachClassPrice) {
        this.coachClassPrice = coachClassPrice;
    }
    /**
   	 * @return the firstClassBooked;
   	 */
    public int getFirstClassBooked() {
        return firstClassBooked;
    }
    /**
   	 * @param firstClassBooked the firstClassBooke to set
   	 */
    public void setFirstClassBooked(int firstClassBooked) {
        this.firstClassBooked = firstClassBooked;
    }
    /**
   	 * @return the coachClassBooked;
   	 */
    public int getCoachClassBooked() {
        return coachClassBooked;
    }
    /**
   	 * @param coachClassBooked the irstClassBooked to set
   	 */
    public void setCoachClassBooked(int coachClassBooked) {
        this.coachClassBooked = coachClassBooked;
    }

    public String depTimeToDate() throws ParseException {
        SimpleDateFormat time = new SimpleDateFormat("yyyy MMM dd HH:mm z", Locale.ENGLISH);
        SimpleDateFormat date = new SimpleDateFormat("yyyy_MM_dd");
        date.setTimeZone(TimeZone.getTimeZone("GMT"));
        return date.format(time.parse(this.getDepTime()));
    }

    public String depTimeToNextDate() throws ParseException {
        SimpleDateFormat time = new SimpleDateFormat("yyyy MMM dd HH:mm z", Locale.ENGLISH);
        SimpleDateFormat date = new SimpleDateFormat("yyyy_MM_dd");
        date.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date temp = new Date();
        temp.setTime(time.parse(this.getDepTime()).getTime() + 24 * 60 * 60 * 1000);
        return date.format(temp);
    }

    public void setLocalTime() throws ParseException {
        SimpleDateFormat time = new SimpleDateFormat("yyyy MMM dd HH:mm z", Locale.ENGLISH);
        Date temp = new Date();
        /**
         * set departing airport local time
         */
        temp.setTime(time.parse(this.getDepTime()).getTime());
        time.setTimeZone(findTz(this.depAirportCode));
        this.localDepTime = time.format(temp);

        temp.setTime(time.parse(this.getArrTime()).getTime());
        time.setTimeZone(findTz(this.arrAirportCode));
        this.localArrTime = time.format(temp);
    }

    public boolean hasCoach() {
        int maxCoach = this.getAirplane().getMaxCoach();
        int curCoach = this.getCoachClassBooked();
        return (maxCoach - curCoach) > 0;
    }

    public boolean hasFirst() {
        int maxFirst = getAirplane().getMaxFirst();
        int curFirst = getFirstClassBooked();
        return (maxFirst - curFirst) > 0;
    }
    /**
     * @param code airport code to return it's timezone
   	 * @return the timezone;
   	 */
    private TimeZone findTz(String code) {
        TimeZone tz = TimeZone.getDefault();
        for (Airport airport : HttpUtil.airports) {
            if (code.equals(airport.getCode())) {
                tz = TimeZone.getTimeZone(TimezoneMapper.latLngToTimezoneString(airport.getLatitude(), airport.getLongitude()));
                break;
            }
        }
        return tz;
    }
}
