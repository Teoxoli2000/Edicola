package it.unipv.po.edicola.model.market.payment;

import it.unipv.po.edicola.model.exception.LocationNotFoundException;
import it.unipv.po.edicola.model.product.IProduct;
import it.unipv.po.edicola.model.shop.ILocation;
import it.unipv.po.edicola.model.shop.INewsstand;

public class Exit extends Payment {
	
	public Exit(Integer paymentId, ILocation shoppingCart) {
		super(paymentId, shoppingCart);
	}

	@Override
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
}
