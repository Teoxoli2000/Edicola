package it.unipv.po.edicola.model.market.coupon.strategy;

import java.util.HashSet;

import it.unipv.po.edicola.model.exception.CouponNotValidException;
import it.unipv.po.edicola.model.market.coupon.Coupon;
import it.unipv.po.edicola.model.market.coupon.ICoupon;
import it.unipv.po.edicola.model.market.payment.IPayment;

public class CompositeCoupon extends Coupon {
	private HashSet<ICoupon> coupons;
	
	public CompositeCoupon() {
		super();
		this.coupons = new HashSet<ICoupon>();
	}
	
	/**
	 * @param description
	 * @param couponId
	 * @param discount
	 */
	public CompositeCoupon(String couponId, Double discount, String description) {
		super(couponId, discount, description);
		this.coupons = new HashSet<ICoupon>();
	}

	@Override
	public Boolean isValid() {
		Boolean result = true;
		for(ICoupon coupon: coupons) {
			result = coupon.isValid() && result;
		}
		return result;
	}
	
	@Override
	public void useCoupon(IPayment payment) throws CouponNotValidException {
		setPayment(payment);
		
		for(ICoupon c: coupons) {
			c.setPayment(getPayment());
			c.setDiscount(getDiscount());
			c.setDescription(getDescription());
			c.setCouponId(getCouponId());
			
			if(!c.isValid())
				throw new CouponNotValidException();
			
			try {
				c.useCoupon(payment);
			} catch (Exception e) {
				throw new CouponNotValidException();
			}
		}
	}
	
	public void addCoupon(ICoupon coupon) {
		coupons.add(coupon);
	}
	
	public void removeCoupon(ICoupon coupon) {
		coupons.remove(coupon);
	}

}
