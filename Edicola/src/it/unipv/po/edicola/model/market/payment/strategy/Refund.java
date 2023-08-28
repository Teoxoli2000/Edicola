package it.unipv.po.edicola.model.market.payment.strategy;

import it.unipv.po.edicola.model.shop.INewsstand;

public class Refund extends Entrance {
	
	public Refund() {
		super();
	}

	@Override
	public void changeNewsstandAccounting(INewsstand newsstand) {
		newsstand.getAccounting().addRefund(this);
	}

}
