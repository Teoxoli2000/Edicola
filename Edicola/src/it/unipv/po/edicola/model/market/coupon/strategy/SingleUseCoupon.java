package it.unipv.po.edicola.model.market.coupon.strategy;

import it.unipv.po.edicola.mapper.MapperFacade;
import it.unipv.po.edicola.model.market.coupon.Coupon;

public class SingleUseCoupon extends Coupon {
	private String singleIdCoupon;

	public SingleUseCoupon(String personalIdCoupon) {
		super();
		this.singleIdCoupon = personalIdCoupon;
	}

	@Override
	public Boolean isValid() {
		if (MapperFacade.getInstance().getSingleUseCoupon(singleIdCoupon) == null)
			return false;
		
		MapperFacade.getInstance().removeSingleUseCoupon(singleIdCoupon);
		return true;
	}
	
	/**
	 * @return the couponId
	 */
	@Override
	public String getCouponId() {
		return singleIdCoupon;
	}

	/**
	 * @param couponId the couponId to set
	 */
	@Override
	public void setCouponId(String couponId) {
		this.singleIdCoupon = couponId;
	}

}
