package it.unipv.po.edicola.model.market.payment;

import it.unipv.po.edicola.model.exception.LocationNotFoundException;
import it.unipv.po.edicola.model.exception.ProductNotFoundException;
import it.unipv.po.edicola.model.product.IProduct;
import it.unipv.po.edicola.model.shop.ILocation;
import it.unipv.po.edicola.model.shop.INewsstand;

public class Entrance extends Payment {

	public Entrance(Integer paymentId, ILocation shoppingCart) {
		super(paymentId, shoppingCart);
	}

	@Override
	public void changeNewsstandInventory(INewsstand newsstand, ILocation location) 
			throws LocationNotFoundException, ProductNotFoundException {
		
		if (location != null) {
			for(IProduct p: super.getShoppingCart().getProducts().keySet()) {
				if (!location.removeProduct(p, super.getShoppingCart().getProducts().get(p)))
					throw new ProductNotFoundException();
			}
		} else {
			throw new LocationNotFoundException();
		}
	}

	@Override
	public void changeNewsstandAccounting(INewsstand newsstand) {
		newsstand.getAccounting().addEntrance(this);		
	}
}