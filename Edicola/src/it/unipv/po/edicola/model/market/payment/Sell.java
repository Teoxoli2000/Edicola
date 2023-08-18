package it.unipv.po.edicola.model.market.payment;

import it.unipv.po.edicola.model.exception.MainLocationNotFoundException;
import it.unipv.po.edicola.model.exception.ProductNotFoundException;
import it.unipv.po.edicola.model.product.IProduct;
import it.unipv.po.edicola.model.shop.ILocation;
import it.unipv.po.edicola.model.shop.INewsstand;

public class Sell extends Payment {
	public static final String nameClass = "it.unipv.po.edicola.model.market.payment.Sell";

	public Sell(Integer paymentId, ILocation shoppingCart) {
		super(paymentId, shoppingCart);
	}

	@Override
	public void changeNewsstandInventory(INewsstand newsstand) throws MainLocationNotFoundException {
		ILocation mainLocation = newsstand.getMainLocation();
		
		if (mainLocation != null) {
			for(IProduct p: super.getShoppingCart().getProducts().keySet()) {
				try {
					mainLocation.removeProduct(p, super.getShoppingCart().getProducts().get(p));
				} catch (ProductNotFoundException e) {
					//TODO chiedi da dove hai preso il prodotto
				}
			}
		} else {
			throw new MainLocationNotFoundException();
		}
	}

	@Override
	public void changeNewsstandAccounting(INewsstand newsstand) {
		newsstand.getAccounting().addEntrance(this);		
	}
}