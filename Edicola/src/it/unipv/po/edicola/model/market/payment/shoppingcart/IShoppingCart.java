package it.unipv.po.edicola.model.market.payment.shoppingcart;

import it.unipv.po.edicola.model.market.payment.IPayment;

public interface IShoppingCart {
	public IPayment generatePayment();
}
