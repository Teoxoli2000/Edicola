package it.unipv.po.edicola.model.market.payment;

import java.time.LocalDateTime;

import it.unipv.po.edicola.model.exception.CouponNotValidException;
import it.unipv.po.edicola.model.market.coupon.ICoupon;
import it.unipv.po.edicola.model.product.IProduct;
import it.unipv.po.edicola.model.shop.ILocation;


public abstract class Payment implements IPayment {
	private Integer paymentId;
	private Double total;
	private LocalDateTime dateTime;
	
	private ILocation shoppingCart;
	
	public Payment(Integer paymentId, ILocation shoppingCart) {
		super();
		this.paymentId = paymentId;
		this.shoppingCart = shoppingCart;
		this.dateTime = LocalDateTime.now();
		this.total = calculateTotal();
	}

	public Double calculateTotal() {
		double result = 0.0;
		for (IProduct product: shoppingCart.getProducts().keySet()) {
			result = product.getPrize() * shoppingCart.getProducts().get(product) + result;
		}
		return result;
	}
	
	public void useCoupon(ICoupon c) {
		try {
			c.useCoupon(this);
		} catch (CouponNotValidException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ILocation getShoppingCart() {
		return shoppingCart;
	}

	@Override
	public void setShoppingCart(ILocation cart) {
		this.shoppingCart = cart;
	}

	@Override
	public Integer getPaymentId() {
		return paymentId;
	}

	@Override
	public void setPaymentId(Integer id) {
		this.paymentId = id;
	}

	@Override
	public Double getTotal() {
		return total;
	}

	@Override
	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	@Override
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
}
