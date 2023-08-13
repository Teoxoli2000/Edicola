package it.unipv.po.edicola.mapper;

import java.time.LocalDate;
import java.util.HashSet;

import it.unipv.po.edicola.mapper.coupon.ICouponMapper;
import it.unipv.po.edicola.mapper.inventory.IInventoryMapper;
import it.unipv.po.edicola.mapper.member.IMemberMapper;
import it.unipv.po.edicola.mapper.products.IProductsMapper;
import it.unipv.po.edicola.model.market.coupon.ICoupon;
import it.unipv.po.edicola.model.member.IMember;
import it.unipv.po.edicola.model.product.IProduct;
import it.unipv.po.edicola.model.product.magazine.IMagazine;
import it.unipv.po.edicola.model.shop.ILocation;

public class MapperFacade 
	implements  ICouponMapper, IInventoryMapper, IProductsMapper, IMemberMapper {
	
	private static MapperFacade instance;
	
	private MapperFacade() {
		super();
	}
	
	public static MapperFacade getInstance() {
		if (instance == null) {
			instance = new MapperFacade();
		}
		return instance;
	}
	
	public HashSet<IProduct> getCouponValidProducts(ICoupon c){
		return MapperFactory.getCouponMapper().getCouponValidProducts(c);
	}
	
	public Boolean addValidProductsToCoupon(ICoupon c, HashSet<IProduct> product) {
		return MapperFactory.getCouponMapper().addValidProductsToCoupon(c, product);
	}
	
	public Boolean removeValidProductsToCoupon(ICoupon c, HashSet<IProduct> product) {
		return MapperFactory.getCouponMapper().removeValidProductsToCoupon(c, product);
	}
	
	public ICoupon getSingleUseCoupon(String code) {
		return MapperFactory.getCouponMapper().getSingleUseCoupon(code);
	}
	
	public Boolean addSingleUseCoupon(ICoupon c, String code) {
		return MapperFactory.getCouponMapper().addSingleUseCoupon(c, code);
	}
	
	public Boolean removeSingleUseCoupon(String code) {
		return MapperFactory.getCouponMapper().removeSingleUseCoupon(code);
	}
	
	public Boolean addCoupun(ICoupon c) {
		return MapperFactory.getCouponMapper().addCoupun(c);
	}
	
	public Boolean addCoupun(ICoupon c, LocalDate expire, LocalDate begin) {
		return MapperFactory.getCouponMapper().addCoupun(c, expire, begin);
	}
	
	public Boolean removeCoupun(ICoupon c) {
		return MapperFactory.getCouponMapper().removeCoupun(c);
	}
	
	public ICoupon getCoupun(Integer id) {
		return MapperFactory.getCouponMapper().getCoupun(id);
	}
	
	public HashSet<ICoupon> getAllCoupons() {
		return MapperFactory.getCouponMapper().getAllCoupons();
	}
	
	public HashSet<IProduct> getAllProducts() {
		return MapperFactory.getProductsMapper().getAllProducts();
	}

	public HashSet<IProduct> searchProduct(String name){
		return MapperFactory.getProductsMapper().searchProduct(name);
	}
	
	public IProduct searchProduct(Integer idProduct) {
		return MapperFactory.getProductsMapper().searchProduct(idProduct);
	}

	public Boolean updateProduct(IProduct product, IProduct update) {
		return MapperFactory.getProductsMapper().updateProduct(product, update);
	}
	public Boolean updateProduct(IProduct product, Double prize) {
		return MapperFactory.getProductsMapper().updateProduct(product, prize);
	}
	
	public Boolean addProduct(IProduct product) {
		return MapperFactory.getProductsMapper().addProduct(product);
	}

	public Boolean addMagazine(IMagazine magazine) {
		return MapperFactory.getProductsMapper().addMagazine(magazine);
	}
	
	public Boolean updateMagazine(IProduct product, IMagazine update) {
		return MapperFactory.getProductsMapper().updateMagazine(product, update);
	}
	
	public HashSet<ILocation> getInventory() {
		return MapperFactory.getInventoryMapper().getInventory();
	}
	
	public Boolean addStorage(ILocation location) {
		return MapperFactory.getInventoryMapper().addStorage(location);
	}
	
	public Boolean removeStorage(ILocation location) {
		return MapperFactory.getInventoryMapper().removeStorage(location);
	}
	
	public Boolean updateStorage(ILocation location, String name, Integer priority) {
		return MapperFactory.getInventoryMapper().updateStorage(location, name, priority);
	}
	
	public Boolean updateInventory(ILocation location, IProduct product, Integer quantity) {
		return MapperFactory.getInventoryMapper().updateInventory(location, product, quantity);
	}
	
	public Boolean addProductInInventory(ILocation location, IProduct product, Integer quantity) {
		return MapperFactory.getInventoryMapper().addProductInInventory(location, product, quantity);
	}
	
	public Boolean removeProductFromInventory(ILocation location, IProduct product) {
		return MapperFactory.getInventoryMapper().removeProductFromInventory(location, product);
	}
	public ILocation getMainLocation() {
		return MapperFactory.getInventoryMapper().getMainLocation();
	}

	@Override
	public Boolean addMember(IMember member) {
		return MapperFactory.getMemberMapper().addMember(member);
	}

	@Override
	public Boolean removeMember(IMember member) {
		return MapperFactory.getMemberMapper().removeMember(member);
	}

	@Override
	public HashSet<IMember> getAllMembers() {
		return MapperFactory.getMemberMapper().getAllMembers();
	}

	@Override
	public Boolean addEmailMember(IMember member, String email) {
		return MapperFactory.getMemberMapper().addEmailMember(member, email);
	}
}
