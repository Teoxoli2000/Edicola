package it.unipv.po.edicola.model.market.payment;

import it.unipv.po.edicola.model.exception.MainLocationNotFoundException;
import it.unipv.po.edicola.model.product.IProduct;
import it.unipv.po.edicola.model.shop.ILocation;
import it.unipv.po.edicola.model.shop.INewsstand;

public class Buy extends Payment {
	public static final String nameClass = "it.unipv.po.edicola.model.market.payment.Buy";
	
	public Buy(Integer paymentId, ILocation shoppingCart) {
		super(paymentId, shoppingCart);
	}

	@Override
	public void changeNewsstandInventory(INewsstand newsstand) throws MainLocationNotFoundException {
		ILocation mainLocation = newsstand.getMainLocation();
		
		if (mainLocation != null) {
			for(IProduct p: super.getShoppingCart().getProducts().keySet()) {
				mainLocation.addProduct(p, super.getShoppingCart().getProducts().get(p));
			}
		} else {
			throw new MainLocationNotFoundException();
		}
	}

	@Override
	public void changeNewsstandAccounting(INewsstand newsstand) {
		newsstand.getAccounting().addExit(this);
	}
}
