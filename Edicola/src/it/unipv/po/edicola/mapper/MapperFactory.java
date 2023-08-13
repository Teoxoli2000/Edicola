package it.unipv.po.edicola.mapper;

import java.util.Properties;

import it.unipv.po.edicola.mapper.accounting.IAccountingMapper;
import it.unipv.po.edicola.mapper.coupon.ICouponMapper;
import it.unipv.po.edicola.mapper.inventory.IInventoryMapper;
import it.unipv.po.edicola.mapper.member.IMemberMapper;
import it.unipv.po.edicola.mapper.products.IProductsMapper;
import it.unipv.po.edicola.mapper.supplier.ISupplierMapper;
import it.unipv.po.edicola.util.properties.PropertiesSingleton;

public class MapperFactory {
	private static ICouponMapper couponMapper;
	private static IAccountingMapper accountingMapper;
	private static IInventoryMapper inventoryMapper;
	private static IProductsMapper productsMapper;
	private static IMemberMapper memberMapper;
	private static ISupplierMapper supplierMapper;
	
	private static String PRODUCTSMAPPER_PROPERTYNAME = "products.mapper.class";
	private static String COUPONMAPPER_PROPERTYNAME = "coupon.mapper.class";
	private static String ACCOUNTIGMAPPER_PROPERTYNAME = "accounting.mapper.class";
	private static String INVENTORYMAPPER_PROPERTYNAME = "inventory.mapper.class";
	private static String MEMBERMAPPER_PROPERTYNAME = "member.mapper.class";
	private static String SUPPLIERMAPPER_PROPERTYNAME = "supplier.mapper.class";
	
	public static IProductsMapper getProductsMapper() {
		String categoryClassName;

		if (productsMapper == null) {
			try {
				Properties p = PropertiesSingleton.getInstance();
				categoryClassName = p.getProperty(PRODUCTSMAPPER_PROPERTYNAME);
				
				productsMapper = (IProductsMapper) Class.forName(categoryClassName).getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return productsMapper;
	}
	

	public static ISupplierMapper getSupplierMapper() {
		String categoryClassName;

		if (supplierMapper == null) {
			try {
				Properties p = PropertiesSingleton.getInstance();
				categoryClassName = p.getProperty(SUPPLIERMAPPER_PROPERTYNAME);
				
				supplierMapper = (ISupplierMapper) Class.forName(categoryClassName).getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return supplierMapper;
	}
	
	public static IMemberMapper getMemberMapper() {
		String categoryClassName;

		if (memberMapper == null) {
			try {
				Properties p = PropertiesSingleton.getInstance();
				categoryClassName = p.getProperty(MEMBERMAPPER_PROPERTYNAME);
				
				memberMapper = (IMemberMapper) Class.forName(categoryClassName).getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return memberMapper;
	}
	
	public static ICouponMapper getCouponMapper() {
		String categoryClassName;

		if (couponMapper == null) {
			try {
				Properties p = PropertiesSingleton.getInstance();
				categoryClassName = p.getProperty(COUPONMAPPER_PROPERTYNAME);
				
				couponMapper = (ICouponMapper) Class.forName(categoryClassName).getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return couponMapper;
	}
	
	public static IAccountingMapper getAccountingMapper() {
		String categoryClassName;

		if (accountingMapper == null) {
			try {
				Properties p = PropertiesSingleton.getInstance();
				categoryClassName = p.getProperty(ACCOUNTIGMAPPER_PROPERTYNAME);
				
				accountingMapper = (IAccountingMapper) Class.forName(categoryClassName).getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return accountingMapper;
	}
	
	public static IInventoryMapper getInventoryMapper() {
		String categoryClassName;

		if (inventoryMapper == null) {
			try {
				Properties p = PropertiesSingleton.getInstance();
				categoryClassName = p.getProperty(INVENTORYMAPPER_PROPERTYNAME);
				
				inventoryMapper = (IInventoryMapper) Class.forName(categoryClassName).getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return inventoryMapper;
	}
	
	
}
