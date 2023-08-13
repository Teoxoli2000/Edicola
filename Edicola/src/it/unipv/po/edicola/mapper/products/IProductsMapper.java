package it.unipv.po.edicola.mapper.products;

import java.util.HashSet;

import it.unipv.po.edicola.model.product.IProduct;
import it.unipv.po.edicola.model.product.magazine.IMagazine;

public interface IProductsMapper {
	public HashSet<IProduct> getAllProducts();

	public HashSet<IProduct> searchProduct(String name);
	public IProduct searchProduct(Integer idProduct);

	public Boolean updateProduct(IProduct product, IProduct update);
	public Boolean updateProduct(IProduct product, Double prize);
	public Boolean addProduct(IProduct product);

	public Boolean addMagazine(IMagazine magazine);
	public Boolean updateMagazine(IProduct product, IMagazine update);
}
