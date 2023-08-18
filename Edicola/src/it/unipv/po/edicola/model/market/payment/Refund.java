package it.unipv.po.edicola.model.market.payment;

import it.unipv.po.edicola.model.shop.ILocation;
import it.unipv.po.edicola.model.shop.INewsstand;

public class Refund extends Entrance {
	
	public Refund(Integer paymentId, ILocation shoppingCart) {
		super(paymentId, shoppingCart);
	}

	@Override
	public void changeNewsstandAccounting(INewsstand newsstand) {
		newsstand.getAccounting().addRefund(this);
	}

}
