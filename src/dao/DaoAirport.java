package dao;

import beans.Airport;
import org.w3c.dom.CharacterData;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

/**
 * @author Tomas 
 * @version 2.0
 * @since 2017/11/03
 */
public class DaoAirport {
	/**
	 * Builds collection of airports from airports described in XML
	 * 
	 * Parses an XML string to read each of the airports and adds each valid airport 
	 * to the collection. The method uses Java DOM (Document Object Model) to convert
	 * from XML to Java primitives.
	 * 
	 * @param xmlAirports XML string containing set of airports 
	 * @return true if the collection was modified, false otherwise
	 * @throws NullPointerException included to keep signature consistent with other addAll methods
	 * 
	 */
	
    public static ArrayList<Airport> addAll (String xmlAirports) throws NullPointerException {
        ArrayList<Airport> airports = new ArrayList<>();

        Document docAirports = buildDomDoc (xmlAirports);
        assert docAirports != null;
        NodeList nodesAirports = docAirports.getElementsByTagName("Airport");

        for (int i = 0; i < nodesAirports.getLength(); i++) {
            Element elementAirport = (Element) nodesAirports.item(i);
            Airport airport = buildAirport (elementAirport);

            if (airport.isValid()) {
                airports.add(airport);
            }
        }

        return airports;
    }
    /**
	 * Creates an Airport object form a DOM node
	 * 
	 * Processes a DOM Node that describes an Airport and creates an Airport object from the information
	 * @param nodeAirport is a DOM Node describing an Airport
	 * @return Airport objects created from the DOM Node representation of the Airport
	 * 
	 */
    static private Airport buildAirport (Node nodeAirport) {
        Airport airport = new Airport();

        String name;
        String code;
        double latitude;
        double longitude;

        // The airport element has attributes of Name and 3 character airport code
        Element elementAirport = (Element) nodeAirport;
        name = elementAirport.getAttributeNode("Name").getValue();
        code = elementAirport.getAttributeNode("Code").getValue();

        // The latitude and longitude are child elements
        Element elementLatLng;
        elementLatLng = (Element)elementAirport.getElementsByTagName("Latitude").item(0);
        latitude = Double.parseDouble(getCharacterDataFromElement(elementLatLng));

        elementLatLng = (Element)elementAirport.getElementsByTagName("Longitude").item(0);
        longitude = Double.parseDouble(getCharacterDataFromElement(elementLatLng));

        airport.setName(name);
        airport.setCode(code);
        airport.setLatitude(latitude);
        airport.setLongitude(longitude);

        return airport;
    }

    /**
     * Builds a DOM tree from an XML string
     *
     * Parses the XML file and returns a DOM tree that can be processed
     *
     * @param xmlString XML String containing set of objects
     * @return DOM tree from parsed XML or null if exception is caught
     */
    static private Document buildDomDoc (String xmlString) {
        try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            InputSource inputSource = new InputSource();
            inputSource.setCharacterStream(new StringReader(xmlString));

            return docBuilder.parse(inputSource);
        }
        catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Retrieve character data from an element if it exists
     *
     * @param e is the DOM Element to retrieve character data from
     * @return the character data as String [possibly empty String]
     */
    private static String getCharacterDataFromElement (Element e) {
        Node child = e.getFirstChild();
        if (child instanceof CharacterData) {
            CharacterData cd = (CharacterData) child;
            return cd.getData();
        }
        return "";
    }
}
