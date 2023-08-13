package it.unipv.po.edicola.model.market.coupon.factory;


import java.time.LocalDate;
import java.util.Collection;

import it.unipv.po.edicola.model.market.coupon.ICoupon;
import it.unipv.po.edicola.model.product.IProduct;

public interface IFactoryCoupon {
	public ICoupon createCoupon(String CouponId, Double discount, String description);
	public ICoupon addValidProducts(ICoupon c, Collection<IProduct> products);
	public ICoupon addValidPeriod(ICoupon c, LocalDate expire, LocalDate begin);
	public ICoupon addSingleUse(ICoupon c, String code);
}
