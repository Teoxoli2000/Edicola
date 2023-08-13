package it.unipv.po.edicola.model.market.coupon;

import it.unipv.po.edicola.model.exception.CouponNotValidException;
import it.unipv.po.edicola.model.market.payment.IPayment;

public abstract class Coupon implements ICoupon {
	private String description;
	private String couponId;
	private Double discount;
	
	private IPayment payment;
	
	public Coupon() {
		super();
	}

	/**
	 * @param couponId
	 * @param discount
	 * @param description
	 */
	public Coupon(String couponId, Double discount, String description) {
		super();
		this.description = description;
		this.couponId = couponId;
		this.discount = discount;
	}

	@Override
	public void useCoupon(IPayment payment) throws CouponNotValidException {
		setPayment(payment);
		
		if (!isValid())
			throw new CouponNotValidException();
		
		payment.setTotal(discount * payment.calculateTotal());
	}

	/**
	 * @return the description
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the couponId
	 */
	@Override
	public String getCouponId() {
		return couponId;
	}

	/**
	 * @param couponId the couponId to set
	 */
	@Override
	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	/**
	 * @return the discount
	 */
	@Override
	public Double getDiscount() {
		return discount;
	}

	/**
	 * @param discount the discount to set
	 */
	@Override
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	
	@Override
	public IPayment getPayment() {
		return payment;
	}
	
	@Override
	public void setPayment(IPayment payment) {
		this.payment = payment;
	}

}
