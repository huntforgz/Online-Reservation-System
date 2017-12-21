package beans;

/**
 * This class stores information about the airplane.  
 *   
 * @author Tomas 
 * @version 2.0
 * @since 2017-09-20
 *
 */
public class Airplane {
	/**
	 *  Attributes of an airplane which same as  server Airplane XML
	 */
    private String manufacturer;
    private String name;
    private int maxFirst;
    private int maxCoach;

    public Airplane(String name){
        this.name=name;
    }
    public Airplane(){
    	/**
    	 * default constructor
    	 */
    	
        manufacturer = "";
        name = "";
        maxFirst = 0;
        maxCoach = 0;
    }

    public Airplane(String manufacturer, String name, int maxFirst, int maxCoach) {
    	/**
    	 * constructor with all required field values supplied
    	 * 
    	 * This constructor will create a valid Airplane object
    	 * 
    	 * @param manufacturer is the manufacturer of the airplane
    	 * @param name is the name of the airplane
    	 * @param maxFirst is the max number of first class seats  on the airplane
    	 * @param maxCoach is the max number of coach seats  on the plane
    	 * 
    	 */

        this.manufacturer = manufacturer;
        this.name = name;
        this.maxFirst = maxFirst;
        this.maxCoach = maxCoach;
    }
    
    /**
	 * get the manufacturer of the airplane
	 * 
	 * @return the manufacturer of the airplane
	 */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
	 * set the manufacturer of the airplane
	 * 
	 * @param manufacturer is the manufacturer of the airplane
	 */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    /**
	 * get the name of the airplane
	 * 
	 * @return the name of the airplane
	 */
    public String getName() {
        return name;
    }
    /**
  	 * set the model of the airplane
  	 * 
  	 * @param name is the model of the airplane
  	 */
    public void setName(String name) {
        this.name = name;
    }
    /**
	 * get the number of first class seats on the model
	 * 
	 * @return the number of first class seats on the model
	 */
    public int getMaxFirst() {
        return maxFirst;
    }
    /**
	 * set the number of first class seats on the model
	 * 
	 * @param maxFirst is the number of first class seats available on the model
	 */
    public void setMaxFirst(int maxFirst) {
        if(isValidSeat(maxFirst)) {
            this.maxFirst = maxFirst;
        }
        else
            throw new IllegalArgumentException(Integer.toString(maxFirst));
    }
    /**
	 * get the number of coach seats on the model
	 * 
	 * @return the number of coach seats on the model
	 */
    public int getMaxCoach() {
        return maxCoach;
    }
    /** 
	 * set the number of coach seats on the model
	 * 
	 * @param maxCoach is the number of coach seats available on the model
	 */
    public void setMaxCoach(int maxCoach) {
        if(isValidSeat(maxCoach)) {
            this.maxCoach = maxCoach;
        }
        else
            throw new IllegalArgumentException(Integer.toString(maxCoach));
    }
    /**
   	 * judge whether the number of max seat number of each seat type is valid
   	 * 
   	 * @return the boolean value of judgment of seat number validation
   	 */
    public boolean isValid(){
        return isValidSeat(this.getMaxCoach()) && isValidSeat(this.getMaxFirst());
    }
    /**
   	 * judge whether a number is bigger than 0
   	 * 
   	 * @return the Not null number of  seats on the model
   	 */
    private boolean isValidSeat(int seatNum) {
        return seatNum > 0;
    }
}
