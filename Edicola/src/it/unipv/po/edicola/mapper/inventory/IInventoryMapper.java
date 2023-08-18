package it.unipv.po.edicola.mapper.inventory;

import java.util.HashSet;

import it.unipv.po.edicola.model.product.IProduct;
import it.unipv.po.edicola.model.shop.ILocation;

public interface IInventoryMapper {
	public HashSet<ILocation> getInventory();
	
	public Boolean addStorage(ILocation location);
	public Boolean removeStorage(ILocation location);
	public Boolean updateStorage(ILocation location, String name, Integer priority);
	
	public Boolean updateInventory(ILocation location, IProduct product, Integer quantity);
	public Boolean addProductInInventory(ILocation location, IProduct product, Integer quantity);
	public Boolean removeProductFromInventory(ILocation location, IProduct product);
	
}
