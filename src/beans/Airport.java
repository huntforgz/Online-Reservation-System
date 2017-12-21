package beans;

import util.Saps;

/**
 * This class stores  values about  an airport.
 * Attributes are accessed via get and set methods.
 * 
 * @author Tomas
 * @version 2.0
 * @since 2017-09-20
 *
 */
public class Airport {
	/**
	 * Airport attributes as defined by the CS509 server 
	 */
    private String code;
    private String name;
    private double latitude;
    private double longitude;

    public Airport(){
    	/**
    	 * Default constructor without parameters    	  
    	 */	
        code = "";
        name = "";
        latitude = Double.MAX_VALUE;
        longitude = Double.MAX_VALUE;
    }
    /**
	 * Initializing constructor.
	 * 
	 * All attributes are initialized with input values
	 *  
	 * @param name The human readable name of the airport
	 * @param code The 3 letter code for the airport
	 * @param latitude The north/south coordinate of the airport 
	 * @param longitude The east/west coordinate of the airport
	 * 
	 */
    public Airport(String name, String code, double latitude, double longitude) {
        if (!isValidName(name)) {
            throw new IllegalArgumentException(name);
        }
        if (!isValidCode(code)) {
            throw new IllegalArgumentException(code);
        }
        if (!isValidLatitude(latitude)) {
            throw new IllegalArgumentException(Double.toString(latitude));
        }
        if (!isValidLongitude(longitude)) {
            throw new IllegalArgumentException(Double.toString(longitude));
        }
        this.name = name;
        this.code = code;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    /**
  	 * get the airport name
  	 * 
  	 * @return Airport name
  	 */
    public String getName() {
        return name;
    }
    /**
	 * Set the airport name
	 * 
	 * @param name The human readable name of the airport
	 */
    public void setName(String name) {
        if(isValidName(name)) {
            this.name = name;
        }
        else
            throw new IllegalArgumentException(name);
    }
    /**
	 * Get the 3 letter airport code
	 * 
	 * @return The 3 letter airport code
	 */
    public String getCode() {
        return code;
    }
    /**
	 * set the airport 3 letter code
	 * 
	 * @param code The 3 letter code for the airport
	 */
    public void setCode(String code) {
        if(isValidCode(code)) {
            this.code = code;
        }
        else
            throw new IllegalArgumentException(code);
    }
    /**
	 * Get the latitude for the airport
	 * 
	 * @return The north/south coordinate of the airport 
	 */
    public double getLatitude() {
        return latitude;
    }
    /**
	 * Set the latitude for the airport
	 * 
	 * @param latitude The north/south coordinate of the airport 
	 */
    public void setLatitude(double latitude) {
        if(isValidLatitude(latitude)) {
            this.latitude = latitude;
        }
        else
            throw new IllegalArgumentException(Double.toString(latitude));
    }
    public void setLatitude(String latitude) {
        if(isValidLatitude(latitude)) {
            this.latitude = Double.parseDouble(latitude);
        }
        else
            throw new IllegalArgumentException(latitude);
    }
    /**
	 * get the longitude for the airport
	 * 
	 * @return The east/west coordinate of the airport
	 */
    public double getLongitude() {
        return longitude;
    }
    /**
	 * Set the longitude for the airport
	 * 
	 * @param longitude The east/west coordinate of the airport
	 */
    public void setLongitude(double longitude) {
        if(isValidLongitude(longitude)) {
            this.longitude = longitude;
        }
        else
            throw new IllegalArgumentException(Double.toString(longitude));
    }
    public void setLongitude(String longitude) {
        if(isValidLongitude(longitude)) {
            this.longitude = Double.parseDouble(longitude);
        }
        else
            throw new IllegalArgumentException(longitude);
    }
    /**
	 * Determine if object instance has valid attribute data per the server return value
	 * 
	 * Verifies the name is not null and not an empty string. Verifies code is 3 characters in length.
	 * Verifies latitude is between +90.0 north pole and -90.0 south pole.
	 * Verifies longitude is between +180.0 east prime meridian and -180.0 west prime meridian.
	 * 
	 * @return true if object passes above validation checks
	 * 
	 */
    public boolean isValid() {

        // If the name isn't valid, the object isn't valid
        if (!isValidName(name))
            return false;

        // If we don't have a 3 character code, object isn't valid
        if (!isValidCode(code))
            return false;

        // Verify latitude and longitude are within range
        return isValidLatitude(latitude) && isValidLongitude(longitude);
    }
    /** 
	 * Verifies the name is not null and not an empty string. Verifies code is 3 characters in length.
	 * @return true if object passes above validation checks
	 * 
	 */
    private boolean isValidName(String name) {
        return (name != null) && (name != "");
    }
    /**
	 *verifies the code is not null and  is 3 characters in length.
	 
	 * 
	 * @return true if object passes above validation checks
	 * 
	 */
    private boolean isValidCode(String code) {
        return (code != null) && (code.length() == 3);
    }
    /**
	 
	 * Verifies latitude is between +90.0 north pole and -90.0 south pole.
	 * 
	 * @return true if object passes above validation checks
	 * 
	 */
    private boolean isValidLatitude(double latitude) {
        return (!(latitude > Saps.MAX_LATITUDE)) && (!(latitude < Saps.MIN_LATITUDE));
    }
    /**
	 * Verifies longitude is between +180.0 east prime meridian and -180.0 west prime meridian.
	 * 
	 * @return true if object passes above validation checks
	 * 
	 */
    private boolean isValidLatitude(String latitude) {
        double lat;
        try {
            lat = Double.parseDouble(latitude);
        } catch (NullPointerException | NumberFormatException ex) {
            return false;
        }
        return isValidLatitude(lat);
    }

    private boolean isValidLongitude(double longitude) {
        return (!(longitude > Saps.MAX_LONGITUDE)) && (!(longitude < Saps.MIN_LONGITUDE));
    }
    private boolean isValidLongitude(String longitude) {
        double lon;
        try {
            lon = Double.parseDouble(longitude);
        } catch (NullPointerException | NumberFormatException ex) {
            return false;
        }
        return isValidLongitude(lon);
    }
}
