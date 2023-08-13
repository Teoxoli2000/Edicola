package it.unipv.po.edicola.util.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Questa classe serve per avere un unica istanza delle properties
 * il pattern singlgeton è implementato tramite la lazy initialization
 * 
 * */

public class PropertiesSingleton extends Properties {

	private static final long serialVersionUID = 7167841115906553881L;
	private static Properties instance;
	
	/**
	 * @return restituisce l'istanza di properties
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static Properties getInstance() throws FileNotFoundException, IOException {
		if (instance == null) {
			instance = new PropertiesSingleton(System.getProperties());
			instance.load(new FileInputStream("../Edicola/properties/properties"));
		}
		return instance;
	}
	
	/**
	 * @param defaults 
	 */
	private PropertiesSingleton(Properties defaults) {
		super(defaults);
	}
	
}
