package it.unipv.po.edicola.model.market.payment.strategy;


import it.unipv.po.edicola.model.market.payment.Payment;

import it.unipv.po.edicola.model.shop.INewsstand;

public class Entrance extends Payment {
	
	public Entrance() {
		super();
	}
	@Override
	public void changeNewsstandInventory(INewsstand old, INewsstand now)  {
		old = now;
	}

	@Override
	public void changeNewsstandAccounting(INewsstand newsstand) {
		newsstand.getAccounting().addEntrance(this);		
	}
}