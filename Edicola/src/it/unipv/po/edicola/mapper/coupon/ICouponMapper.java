package it.unipv.po.edicola.mapper.coupon;


import java.time.LocalDate;
import java.util.HashSet;

import it.unipv.po.edicola.model.market.coupon.ICoupon;
import it.unipv.po.edicola.model.product.IProduct;


public interface ICouponMapper {
	public HashSet<IProduct> getCouponValidProducts(ICoupon c);
	public Boolean addValidProductsToCoupon(ICoupon c, HashSet<IProduct> product);
	public Boolean removeValidProductsToCoupon(ICoupon c, HashSet<IProduct> product);
	
	public ICoupon getSingleUseCoupon(String code);
	public Boolean addSingleUseCoupon(ICoupon c, String code);
	public Boolean removeSingleUseCoupon(String code);
		
	public Boolean addCoupun(ICoupon c);
	public Boolean addCoupun(ICoupon c, LocalDate expire, LocalDate begin);
	public Boolean removeCoupun(ICoupon c);
	public ICoupon getCoupun(Integer id);
	public HashSet<ICoupon> getAllCoupons();
}
