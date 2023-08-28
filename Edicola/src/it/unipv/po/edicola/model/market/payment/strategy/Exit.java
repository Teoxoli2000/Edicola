package it.unipv.po.edicola.model.market.payment.strategy;

import it.unipv.po.edicola.model.exception.LocationNotFoundException;
import it.unipv.po.edicola.model.market.payment.Payment;
import it.unipv.po.edicola.model.product.IProduct;
import it.unipv.po.edicola.model.shop.ILocation;
import it.unipv.po.edicola.model.shop.INewsstand;

public class Exit extends Payment {
	public Exit() {
		super();
	}

	public void changeNewsstandInventory(INewsstand newsstand, ILocation location) 
			throws LocationNotFoundException {
		
		if (location != null) {
			for(IProduct p: super.getShoppingCart().getProducts().keySet()) {
				location.addProduct(p, super.getShoppingCart().getProducts().get(p));
			}
		} else {
			throw new LocationNotFoundException();
		}
	}

	@Override
	public void changeNewsstandAccounting(INewsstand newsstand) {
		newsstand.getAccounting().addExit(this);
	}

	@Override
	public void changeNewsstandInventory(INewsstand old, INewsstand now) {
		// TODO Auto-generated method stub
		
	}
}
