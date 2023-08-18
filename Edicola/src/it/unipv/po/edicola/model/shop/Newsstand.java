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
		HashSet<ILocation> result = new HashSet<ILocation>();
		
		for(ILocation l: wards) {
			for(IProduct p: l.getProducts().keySet()) {
				if(p.getIdProduct() == id)
					result.add(l);
			}
		}
		
		if (result.isEmpty()) {
			throw new ProductNotFoundException();
		}
		
		return result;
	}
	
	/**
	 * ricerca di un prodotto all'interno dell'edicola tramite il nome del prodotto
	 * @param nameProduct nome del prodotto da cercare
	 * @return un HashTable di ambienti in cui il prodotto è presente e quale 
	 * 		prodotto è (un prodotto può avere lo stesso nome)
	 * @throws nel caso in cui non è presente il prodotto cercato
	 */
	public Hashtable<ILocation, IProduct> searchProductInStore(String nameProduct) throws ProductNotFoundException {
		Hashtable<ILocation,IProduct> result = new Hashtable<ILocation,IProduct>();
		
		for(ILocation l: wards) {
			for(IProduct p: l.getProducts().keySet()) {
				if(p.getName() == nameProduct)
					result.put(l, p);
			}
		}
		
		if (result.isEmpty()) {
			throw new ProductNotFoundException();
		}
		
		return result;
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
