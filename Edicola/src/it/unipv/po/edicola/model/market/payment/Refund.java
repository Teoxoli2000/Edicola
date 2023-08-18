package it.unipv.po.edicola.model.market.payment;

import it.unipv.po.edicola.model.exception.MainLocationNotFoundException;
import it.unipv.po.edicola.model.shop.ILocation;
import it.unipv.po.edicola.model.shop.INewsstand;

public class Refund extends Payment{

	public Refund(Integer paymentId, ILocation shoppingCart) {
		super(paymentId, shoppingCart);
	}

	@Override
	public void changeNewsstandInventory(INewsstand newsstand) throws MainLocationNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeNewsstandAccounting(INewsstand newsstand) {
		// TODO Auto-generated method stub
		
	}

}
