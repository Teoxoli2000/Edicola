package it.unipv.po.edicola.model.market.coupon.strategy;

import java.time.LocalDate;

import it.unipv.po.edicola.model.market.coupon.Coupon;

public class PeriodValidCoupon extends Coupon {
	private LocalDate expiry;
	private LocalDate begin;
	private LocalDate now;
	
	public PeriodValidCoupon() {
		super();
		now = LocalDate.now();
	}
	
	public PeriodValidCoupon(LocalDate date1, LocalDate date2) {
		super();
		if (date1.isAfter(date2)) {	
			this.begin = date2;
			this.expiry = date1;
		}
		else {
			this.begin = date1;
			this.expiry = date2;
		}
		now = LocalDate.now();
	}
	
	public PeriodValidCoupon(LocalDate expiry) {
		super();
		this.expiry = expiry;
		begin = LocalDate.MIN;	
		now = LocalDate.now();
	}

	@Override
	public Boolean isValid()  {
		if (expiry.isEqual(now) || begin.isEqual(now))
			return true;
		if (expiry.isBefore(now))
			return false;
		if (begin.isAfter(now))
			return false; 
		
		return true;
	}
}
