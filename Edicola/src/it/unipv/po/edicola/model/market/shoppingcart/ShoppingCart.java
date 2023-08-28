package it.unipv.po.edicola.model.market.shoppingcart;

import java.util.HashSet;
import java.util.Hashtable;

import it.unipv.po.edicola.model.exception.ProductNotFoundException;
import it.unipv.po.edicola.model.market.payment.IPayment;
import it.unipv.po.edicola.model.market.payment.PaymentFactory;
import it.unipv.po.edicola.model.product.IProduct;
import it.unipv.po.edicola.model.shop.ILocation;
import it.unipv.po.edicola.model.shop.Storage;

public class ShoppingCart extends Storage implements IShoppingCart {
	private Hashtable<IProduct, Hashtable<ILocation, Integer>> takens;
	private  Hashtable<ILocation, Integer> wards;
	
	public ShoppingCart(String name) {
		super(name);
		this.wards = new  Hashtable<ILocation, Integer>();
		this.takens = new Hashtable<IProduct,  Hashtable<ILocation, Integer>>();
	}
	
	@Override
	public IPayment generatePayment() {
		IPayment result = PaymentFactory.getPayment();
		result.setShoppingCart(this);
		return result;
	}
	
	@Override
	public void moveProduct(ILocation provenance, IProduct product, Integer quantity)
			throws IllegalArgumentException, ProductNotFoundException {
		provenance.moveProduct(this, product, quantity);
		wards.put(provenance, quantity);
		takens.put(product, wards);
	}

	/**
	 * @return the takens
	 */
	public Hashtable<IProduct, Hashtable<ILocation, Integer>> getTakens() {
		return takens;
	}

	/**
	 * @param takens the takens to set
	 */
	public void setTakens(Hashtable<IProduct, Hashtable<ILocation, Integer>> takens) {
		this.takens = takens;
	}
	
	
}
