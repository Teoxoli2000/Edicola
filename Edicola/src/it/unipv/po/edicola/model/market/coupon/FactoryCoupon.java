package it.unipv.po.edicola.model.market.coupon;

import java.time.LocalDate;
import java.util.Collection;

import it.unipv.po.edicola.model.market.coupon.strategy.AlwaysValidCoupon;
import it.unipv.po.edicola.model.market.coupon.strategy.CirculationCoupon;
import it.unipv.po.edicola.model.market.coupon.strategy.CompositeCoupon;
import it.unipv.po.edicola.model.market.coupon.strategy.PeriodValidCoupon;
import it.unipv.po.edicola.model.market.coupon.strategy.SingleProductCoupon;
import it.unipv.po.edicola.model.product.IProduct;



public class FactoryCoupon {
	private static FactoryCoupon instanceFactory;
	
	private FactoryCoupon() {
		super();
	}
	
	public static FactoryCoupon getInstanceFactory() {
		if (instanceFactory == null)
			instanceFactory = new FactoryCoupon();
		return instanceFactory;
	}
	
	
	public ICoupon createCoupon(String CouponId, Double discount, String description) {
		return new AlwaysValidCoupon(CouponId, discount, description);
	}
	
	
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
	
	public ICoupon addCirculationCoupon(ICoupon c, String cCouponId) {
		CompositeCoupon result = new CompositeCoupon(c.getCouponId(), c.getDiscount(), c.getDescription());
		result.addCoupon(c);
		result.addCoupon(new CirculationCoupon(cCouponId));
		
		return result;
	}
	
}
