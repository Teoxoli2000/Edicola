package it.unipv.po.edicola.util.address;

/**
 * La classe Address rappresenta un qualsiasi indirizzo postale nel mondo
 */
public class Address {
	private String name; 			// nome o numero della via
    private String streetAddress; 	// indirizzo nella via
    private String city; 			// città 
    private String state; 			// stato
    private String zipCode; 		//zona postale

    public Address(String nm, String streetAddr, String city, String state, String zip) {
    	super();
        name = nm;
        streetAddress = streetAddr;
        this.city = city;
        this.state = state;
        zipCode = zip;
    }

    /**
     * @return the theName
     */
    public String getName() {
        return name;
    }

    /**
     * @param theName the theName to set
     */
    public void setName(String theName) {
        this.name = theName;
    }

    /**
     * @return the streetAddress
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * @param streetAddress the streetAddress to set
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode the zipCode to set
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
}
