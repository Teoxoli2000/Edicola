package it.unipv.po.edicola.model.shop;

import java.util.HashSet;
import java.util.Hashtable;

import it.unipv.po.edicola.model.exception.ProductNotFoundException;
import it.unipv.po.edicola.model.market.IAccounting;
import it.unipv.po.edicola.model.member.MemberBook;
import it.unipv.po.edicola.model.product.IProduct;
import it.unipv.po.edicola.model.product.magazine.IMagazine;
import it.unipv.po.edicola.model.supplier.SupplierBook;

public interface INewsstand {
	public ILocation getInventory();
	public HashSet<ILocation> searchProductInStore(Integer id) 
			throws ProductNotFoundException;
	public Hashtable<ILocation, IProduct> searchProductInStore(String nameProduct) 
			throws ProductNotFoundException;
	public Hashtable<ILocation, IMagazine> searchMagazineInStore(String nameProduct) 
			throws ProductNotFoundException;
	
	public Hashtable<ILocation, IProduct> getProductInStore(Integer id) 
			throws ProductNotFoundException ;
	public Hashtable<ILocation, IProduct> getProductInStore(String name) 
			throws ProductNotFoundException;
	
	public IAccounting getAccounting();
	public void setAccounting(IAccounting accounting);
	
	public HashSet<ILocation> getWards();
	public void setWards(HashSet<ILocation> wards);
	
	public SupplierBook getSupplierBook();
	public void setSupplierBook(SupplierBook book);

	public MemberBook getMemberBook();
	public void setMemberBook(MemberBook book);
	
	
}
