package it.unipv.po.edicola.model.shop;

import java.util.HashSet;

import it.unipv.po.edicola.model.accounting.IAccounting;
import it.unipv.po.edicola.model.member.MemberBook;
import it.unipv.po.edicola.model.supplier.SupplierBook;

public interface INewsstand {
	public ILocation getInventory();
	
	public IAccounting getAccounting();
	public void setAccounting(IAccounting accounting);
	
	public HashSet<ILocation> getWards();
	public void setWards(HashSet<ILocation> wards);

	public ILocation getMainLocation();
	public void setMainLocation(ILocation mainLocation);
	
	public SupplierBook getSupplierBook();
	public void setSupplierBook(SupplierBook book);

	public MemberBook getMemberBook();
	public void setMemberBook(MemberBook book);
}
