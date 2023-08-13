package it.unipv.po.edicola.model.market.coupon.strategy;

import it.unipv.po.edicola.model.market.coupon.Coupon;

public class AlwaysValidCoupon extends Coupon {

	public AlwaysValidCoupon() {
		super();
	}

	/**
	 * @param couponId
	 * @param discount
	 * @param description
	 */
	public AlwaysValidCoupon(String couponId, Double discount, String description) {
		super(couponId, discount, description);
	}

	@Override
	public Boolean isValid() {
		return true;
	}
	
}
