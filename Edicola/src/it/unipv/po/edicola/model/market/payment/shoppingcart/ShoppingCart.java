package it.unipv.po.edicola.model.market.payment.shoppingcart;

import it.unipv.po.edicola.model.market.payment.IPayment;
import it.unipv.po.edicola.model.market.payment.factory.PaymentFactory;
import it.unipv.po.edicola.model.shop.Storage;

public class ShoppingCart extends Storage implements IShoppingCart {
	
	public ShoppingCart(String name) {
		super(name);
	}
	
	@Override
	public IPayment generatePayment() {
		IPayment result = PaymentFactory.getPayment();
		result.setShoppingCart(this);
		return result;
	}
}
