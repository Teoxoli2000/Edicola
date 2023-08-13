package it.unipv.po.edicola.model.market.coupon.factory;

import java.time.LocalDate;
import java.util.Collection;

import it.unipv.po.edicola.model.market.coupon.ICoupon;
import it.unipv.po.edicola.model.market.coupon.strategy.AlwaysValidCoupon;
import it.unipv.po.edicola.model.market.coupon.strategy.CompositeCoupon;
import it.unipv.po.edicola.model.market.coupon.strategy.PeriodValidCoupon;
import it.unipv.po.edicola.model.market.coupon.strategy.SingleUseCoupon;
import it.unipv.po.edicola.model.market.coupon.strategy.SingleProductCoupon;
import it.unipv.po.edicola.model.product.IProduct;



public class FactoryCoupon implements IFactoryCoupon {
	private static FactoryCoupon instanceFactory;
	
	private FactoryCoupon() {
		super();
	}
	
	public static FactoryCoupon getInstanceFactory() {
		if (instanceFactory == null)
			instanceFactory = new FactoryCoupon();
		return instanceFactory;
	}
	
	@Override
	public ICoupon createCoupon(String CouponId, Double discount, String description) {
		return new AlwaysValidCoupon(CouponId, discount, description);
	}
	
	@Override
	public ICoupon addValidProducts(ICoupon c, Collection<IProduct> products) {
		if (products == null)
			return c;
		
		CompositeCoupon result = new CompositeCoupon(c.getCouponId(), c.getDiscount(), c.getDescription());
		result.addCoupon(c);
		for(IProduct p: products) {
			result.addCoupon(new SingleProductCoupon(p));
		}
		return result;
	}
	
	@Override
	public ICoupon addValidPeriod(ICoupon c, LocalDate expire, LocalDate begin) {
		if (expire == null && begin == null)
			return c;
		
		CompositeCoupon result = new CompositeCoupon(c.getCouponId(), c.getDiscount(), c.getDescription());
		result.addCoupon(c);
		
		if (begin != null)
			result.addCoupon(new PeriodValidCoupon(expire, begin));
		else
			result.addCoupon(new PeriodValidCoupon(expire));
		
		return result;
	}
	
	@Override
	public ICoupon addSingleUse(ICoupon c, String code) {
		if (code == null)
			return c;
		
		CompositeCoupon result = new CompositeCoupon(c.getCouponId(), c.getDiscount(), c.getDescription());
		result.addCoupon(c);
		
		result.addCoupon(new SingleUseCoupon(code));
		return result;
	}
	
}
