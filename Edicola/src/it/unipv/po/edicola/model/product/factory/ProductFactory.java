package it.unipv.po.edicola.model.product.factory;

import java.time.LocalDate;
import java.util.HashSet;

import it.unipv.po.edicola.model.product.IProduct;
import it.unipv.po.edicola.model.product.Product;
import it.unipv.po.edicola.model.product.magazine.Magazine;

public class ProductFactory {

	private static HashSet<IProduct> instanceProducts;
	private static ProductFactory instanceFactory;
	
	private ProductFactory() {
		super();
		ProductFactory.instanceProducts = new HashSet<IProduct>();
	}
	
	public static ProductFactory getInstanceFactory() {
		if (instanceFactory == null)
			instanceFactory = new ProductFactory();
		return instanceFactory;
	}
	
	public static IProduct createProduct(Double prize, Integer idProduct, String name, LocalDate date, String period) {
		IProduct result;
		if (date == null)
			return createProduct(prize, idProduct, name);
		
		result = new Magazine(prize, idProduct, name, date, period);
		
		for (IProduct instance: instanceProducts) {
			if (result.isEqual(instance))
				return instance;
		}
		
		instanceProducts.add(result);
		return result;
		
	}
	
	public static IProduct createProduct(Double prize, Integer idProduct, String name) {
		IProduct result;

		result = new Product(prize, idProduct, name);
		
		for (IProduct instance: instanceProducts) {
			if (result.isEqual(instance))
				return instance;
		}
		
		instanceProducts.add(result);
		return result;
	}
}
