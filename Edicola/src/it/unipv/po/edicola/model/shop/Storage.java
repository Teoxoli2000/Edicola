package it.unipv.po.edicola.model.shop;

import java.util.*;

import it.unipv.po.edicola.model.exception.ProductNotFoundException;
import it.unipv.po.edicola.model.product.IProduct;


/**
 * Storage rappresenta i magazzini o gli ambienti dell'edicola, implementando l'interfaccia ILocation
 */
public class Storage implements ILocation {
	private String name; 							// nome
	private Hashtable<IProduct, Integer> products; 	// prodotti contenuti

	public Storage(String name) {
		super();
		this.name = name;
		this.products = new Hashtable<IProduct, Integer>();
	}
	
	/**
	 * sposta un prodotto da un ambiente ad un altro
	 * @param destination si vuole spostare il prodotto in quell'ambiente
	 * @param product prodotto da spostare
	 * @param quantity numero di prodotti da spostare
	 * @throws ProductNotFoundException
	 */
	@Override
	public void moveProductTo(ILocation destination, IProduct product, Integer quantity) throws ProductNotFoundException {
		try {
			if (quantity <= products.get(product)) {
				this.removeProduct(product, quantity);
				destination.addProduct(product, quantity);
			} else 
				throw new IllegalArgumentException("Arguments not valid: quantity = " + quantity);
		} catch (NullPointerException e) {
			throw new ProductNotFoundException("Product not found in " + getName());
		}
	}
	
	/**
	 * aggiunge un prodotto a products di una certa quantità
	 * @param product prodotto da aggiungere
	 * @param quantity qunatità del prodotto
	 */
	@Override
	public Boolean addProduct(IProduct product, Integer quantity) {
		if (products.containsKey(product)) {
			products.put(product, quantity + products.get(product));
			return true;
		} 
		products.put(product, quantity);
		return false;
	}
	
	/**
	 * rimuove un prodotto a products di una certa quantità
	 * @param product prodotto da aggiungere
	 * @param quantity qunatità del prodotto
	 * @throws ProductNotFoundException
	 */
	@Override
	public Boolean removeProduct(IProduct product, Integer quantity) throws ProductNotFoundException {
		if (!products.containsKey(product))
			throw new ProductNotFoundException("Arguments not valid: " + product.getName() + " not found in products");
		if (products.get(product) > quantity) {
			products.put(product, products.get(product) - quantity);
			return true;
		} 
		products.remove(product);
		return false;
	}
	
	/**
	 * @return name da restituire
	 */
	@Override
	public String getName() {
		return name;
	}
	
	/**
	 * @param name da settare
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return products da restiture
	 */
	@Override
	public Hashtable<IProduct, Integer> getProducts() {
		return products;
	}
	
	/**
	 * @param products da settare
	 */
	public void setProducts(Hashtable<IProduct, Integer> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		String result = "Reparto: " + name + "\nContenente: \n";
		for(IProduct p: products.keySet()) {
			result += p.getName() + "  qta: " + products.get(p) + "\n";
		}
		return result;
	}

}
