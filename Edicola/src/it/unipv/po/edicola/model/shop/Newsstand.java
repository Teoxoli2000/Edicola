package it.unipv.po.edicola.model.shop;

import java.util.HashSet;
import java.util.Hashtable;

import it.unipv.po.edicola.model.accounting.IAccounting;
import it.unipv.po.edicola.model.exception.ProductNotFoundException;
import it.unipv.po.edicola.model.member.MemberBook;
import it.unipv.po.edicola.model.product.IProduct;
import it.unipv.po.edicola.model.supplier.SupplierBook;


/**
 * Newwstand è la classe che rappresenta l'intera edicola
 */
public class Newsstand implements INewsstand {
	private HashSet<ILocation> wards; 	// ambienti 
	private ILocation inventory;		// inventario
	private ILocation mainLocation;		// l'ambiente principale
	private IAccounting accounting; 	// contabilità
	private SupplierBook supplierBook; 	// rubrica fornitori
	private MemberBook memberBook; 		// rubrica membri
	
	public Newsstand() {
		super();
		this.wards = new HashSet<ILocation>();
		this.inventory = new Storage("Inventory");
	}
	
	public Newsstand(String nameInventory) {
		super();
		this.wards = new HashSet<ILocation>();
		this.inventory = new Storage(nameInventory);
	}
	
	/**
	 * ricerca di un prodotto all'interno dell'edicola tramite l'id
	 * @param id identifcativo del prodotto da cercare
	 * @return un HashSet di ambienti in cui il prodotto è presente
	 * @throws nel caso in cui non è presente il prodotto cercato
	 */
	public HashSet<ILocation> searchProductInStore(Integer id) throws ProductNotFoundException {
		return null;
		//TODO
	}
	
	/**
	 * ricerca di un prodotto all'interno dell'edicola tramite il nome del prodotto
	 * @param nameProduct nome del prodotto da cercare
	 * @return un HashTable di ambienti in cui il prodotto è presente e quale 
	 * 		prodotto è (un prodotto può avere lo stesso nome)
	 * @throws nel caso in cui non è presente il prodotto cercato
	 */
	public Hashtable<ILocation, IProduct> searchProductInStore(String nameProduct) throws ProductNotFoundException {
		return null;
		//TODO
	}
	
	/**
	 * @param w ambiente da aggiungere a wards
	 */
	public void addWard(ILocation w) {
		wards.add(w);
	}
	
	/**
	 * @param w ambiente da rimuovere da wards
	 */
	public void removeWard(ILocation w) {
		wards.remove(w);
	}
	
	/**
	 * @return restituisce l'inventario
	 */
	@Override
	public ILocation getInventory() {
		Storage temp =  new Storage(inventory.getName());
		for(ILocation l: wards) {
			for(IProduct product: l.getProducts().keySet()) {
				temp.addProduct(product, l.getProducts().get(product));
			}
		}
		inventory.getProducts().putAll(temp.getProducts());
		return inventory;
	}
	
	/**
	 * @return restituisce l'ambiente principale
	 */
	@Override
	public ILocation getMainLocation() {
		return mainLocation;
	}
	
	/**
	 * @param mainLocation imposta l'ambiente principale
	 */
	@Override
	public void setMainLocation(ILocation mainLocation) {
		for(ILocation loc: wards) {
			if(mainLocation.getName().equalsIgnoreCase(loc.getName()))
				this.mainLocation = loc;
		}
	}
	
	/**
	 * @param wards imposta gli ambienti
	 */
	@Override
	public HashSet<ILocation> getWards() {
		return wards;
	}

	/**
	 * @return restituisce gli ambienti
	 */
	@Override
	public void setWards(HashSet<ILocation> wards) {
		this.wards = wards;
	}
	
	/**
	 * @return restituisce la contabilità
	 */
	@Override
	public IAccounting getAccounting() {
		return accounting;
	}
	
	/**
	 * @param accounting imposta la contabilità
	 */
	@Override
	public void setAccounting(IAccounting accounting) {
		this.accounting = accounting;
	}

	/**
	 * @return restituisce la rubrica dei fornitori
	 */
	@Override
	public SupplierBook getSupplierBook() {
		return this.supplierBook;
	}

	/**
	 * @param book imposta la rubrica dei fornitori
	 */
	@Override
	public void setSupplierBook(SupplierBook book) {
		this.supplierBook = book;
	}
	
	/**
	 * @return restituisce la rubrica degli iscritti
	 */
	@Override
	public MemberBook getMemberBook() {
		return this.memberBook;
	}

	/**
	 * @param book imposta la rubrica degli iscritti
	 */
	@Override
	public void setMemberBook(MemberBook book) {
		this.memberBook = book;
	}
	
}
