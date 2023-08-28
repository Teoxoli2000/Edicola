package it.unipv.po.edicola.model.market.payment;

import java.util.Properties;

import it.unipv.po.edicola.util.properties.PropertiesSingleton;


public class PaymentFactory {
	private static IPayment payment;

	private static String PAYMENT_PROPERTYNAME = "payment.class";

	public static IPayment getPayment() {
		String categoryClassName;

		if (payment == null) {
			try {
				Properties p = PropertiesSingleton.getInstance();
				categoryClassName = p.getProperty(PAYMENT_PROPERTYNAME);
				
				payment = (IPayment) Class.forName(categoryClassName).getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return payment;
	}
}
