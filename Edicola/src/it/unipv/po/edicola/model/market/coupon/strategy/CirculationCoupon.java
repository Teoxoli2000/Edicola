package it.unipv.po.edicola.model.market.coupon.strategy;

import it.unipv.po.edicola.mapper.MapperFacade;
import it.unipv.po.edicola.model.exception.CouponNotValidException;
import it.unipv.po.edicola.model.market.coupon.Coupon;
import it.unipv.po.edicola.model.market.payment.IPayment;

public class CirculationCoupon extends Coupon{
	private String circulationCouponId;
	
	public CirculationCoupon() {
		super();
	}
	public CirculationCoupon(String circulationCouponId) {
		super();
		this.circulationCouponId = circulationCouponId;
	}
	
	@Override
	public Boolean isValid() {
		return MapperFacade.getInstance().isNotUsedCoupon(circulationCouponId);
	}
	
	@Override
	public void useCoupon(IPayment payment) throws CouponNotValidException {
		setPayment(payment);
		
		if (!isValid())
			throw new CouponNotValidException();
		
		payment.setTotal(getDiscount() * payment.calculateTotal());
		
		MapperFacade.getInstance().removeUsedCoupon(circulationCouponId);
	}

	/**
	 * @return the circulationCouponId
	 */
	public String getCirculationCouponId() {
		return circulationCouponId;
	}

	/**
	 * @param circulationCouponId the circulationCouponId to set
	 */
	public void setCirculationCouponId(String circulationCouponId) {
		this.circulationCouponId = circulationCouponId;
	}
	
}
