package it.unipv.po.edicola.model.supplier;

import java.util.HashSet;

import it.unipv.po.edicola.model.product.IProduct;
import it.unipv.po.edicola.util.address.Address;
import it.unipv.po.edicola.util.phonenumber.PhoneNumber;


/**
 * Supplier rappresenta un fornitore
 */

public class Supplier { 
	private String name; 					// nome
	private HashSet<IProduct> supplies; 	// forniture del fornitore
	private Integer supplierId; 			// identificativo nel sistema
	private Address adress; 				// indirizzo 
	private PhoneNumber phone; 				// numero telefonico 

	public Supplier(String name, Integer supplierId, Address adress, PhoneNumber phone) {
		super();
		this.name = name;
		this.supplierId = supplierId;
		this.adress = adress;
		this.phone = phone;
		this.supplies = new HashSet<IProduct>();
	}

	/**
	 * @return the supplies
	 */
	public HashSet<IProduct> getSupplies() {
		return supplies;
	}

	/**
	 * @param supplies the supplies to set
	 */
	public void setSupplies(HashSet<IProduct> supplies) {
		this.supplies = supplies;
	}
	
	/**
	 * @param supply la fornitura da aggiungere a supplies
	 */
	public void addSupply(IProduct supply) {
		supplies.add(supply);
	}
	
	/**
	 * @param supply la fornitura da rimuovere da supplies
	 */
	public void removeSupply(IProduct supply) {
		supplies.remove(supply);
	}
	
	/**
	 * @return the supplierId
	 */
	public Integer getSupplierId() {
		return supplierId;
	}

	/**
	 * @param supplierId the supplierId to set
	 */
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	/**
	 * @return the adress
	 */
	public Address getAdress() {
		return adress;
	}

	/**
	 * @param adress the adress to set
	 */
	public void setAdress(Address adress) {
		this.adress = adress;
	}

	/**
	 * @return the phone
	 */
	public PhoneNumber getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(PhoneNumber phone) {
		this.phone = phone;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
