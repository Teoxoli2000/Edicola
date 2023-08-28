package it.unipv.po.edicola.model.market.coupon;

import it.unipv.po.edicola.model.market.payment.IPayment;

public interface ICoupon {
	public IPayment getPayment();
	public void setPayment(IPayment payment);
	
	public String getDescription();
	public void setDescription(String description);
	
	public String getCouponId();
	public void setCouponId(String id);
	
	public Double getDiscount();
	public void setDiscount(Double discount);
	
	public void useCoupon(IPayment products) throws Exception;
	
	public Boolean isValid();
}
