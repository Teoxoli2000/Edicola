package it.unipv.po.edicola.model.market.shoppingcart;

import java.util.HashSet;
import java.util.Hashtable;

import it.unipv.po.edicola.model.market.payment.IPayment;
import it.unipv.po.edicola.model.product.IProduct;
import it.unipv.po.edicola.model.shop.ILocation;

public interface IShoppingCart {
	public IPayment generatePayment();
	
	public Hashtable<IProduct, Hashtable<ILocation, Integer>> getTakens();
	public void setTakens(Hashtable<IProduct, Hashtable<ILocation, Integer>> takens);
}
