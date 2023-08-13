package it.unipv.po.edicola.model.shop.factory;

import java.util.Properties;

import it.unipv.po.edicola.util.properties.PropertiesSingleton;

/**
 * NewsstandAbstractFactory classe che implementa il pattern abstract factory,
 * implementa il pattern attraverso una java reflection
 */
public class NewsstandAbstractFactory {
	private static INewsstandFactory newsstand;

	private static String NEWSSTAND_PROPERTYNAME = "newsstand.generate.class";

	public static INewsstandFactory getNewsstand() {
		String categoryClassName;

		if (newsstand == null) {
			try {
				Properties p = PropertiesSingleton.getInstance();
				categoryClassName = p.getProperty(NEWSSTAND_PROPERTYNAME);
				
				newsstand = (INewsstandFactory) Class.forName(categoryClassName).getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return newsstand;
	}
}
