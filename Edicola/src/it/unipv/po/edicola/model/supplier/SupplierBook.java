package it.unipv.po.edicola.model.supplier;

import java.util.HashSet;

/**
 * SupplierBook rappresenta l'insieme di tutti i fornitori della libreria
 */
public class SupplierBook {
	private HashSet<Supplier> suppliers;

	public SupplierBook() {
		super();
	}

	/**
	 * @return the suppliers
	 */
	public HashSet<Supplier> getSuppliers() {
		return suppliers;
	}

	/**
	 * @param suppliers the suppliers to set
	 */
	public void setSuppliers(HashSet<Supplier> suppliers) {
		this.suppliers = suppliers;
	}
	
	/**
	 * @param supplier il supplier che si vuole aggiungere a suppliers
	 */
	public void addSupplier(Supplier supplier) {
		suppliers.add(supplier);
	}
	
	/**
	 * @param supplier il supplier che si vuole eliminare in suppliers
	 */
	public void removeSupplier(Supplier supplier) {
		suppliers.remove(supplier);
	}
}
