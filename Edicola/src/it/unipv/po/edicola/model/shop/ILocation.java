package it.unipv.po.edicola.model.shop;

import java.util.Hashtable;

import it.unipv.po.edicola.model.exception.ProductNotFoundException;
import it.unipv.po.edicola.model.product.IProduct;

public interface ILocation {
	public String getName();
	public void setName(String name);
	
	public Hashtable<IProduct, Integer> getProducts();
	public Boolean addProduct(IProduct product, Integer quantity);
	public Boolean removeProduct(IProduct product, Integer quantity) 
			throws ProductNotFoundException;
	
	public void moveProductTo(ILocation destination, IProduct product, Integer quantity) 
			throws ProductNotFoundException;
}
