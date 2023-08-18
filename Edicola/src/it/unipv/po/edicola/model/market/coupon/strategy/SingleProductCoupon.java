package it.unipv.po.edicola.model.market.coupon.strategy;

import it.unipv.po.edicola.model.exception.CouponNotValidException;
import it.unipv.po.edicola.model.market.coupon.Coupon;
import it.unipv.po.edicola.model.market.payment.IPayment;
import it.unipv.po.edicola.model.product.IProduct;
import it.unipv.po.edicola.model.product.Product;
import it.unipv.po.edicola.model.shop.ILocation;

public class SingleProductCoupon extends Coupon {
	private IProduct valid;
	private ILocation shoppingCart;

	public SingleProductCoupon() {
		super();
	}
	
	public SingleProductCoupon(IProduct valid) {
		super();
		this.valid = valid;
	}

	@Override
	public Boolean isValid() {
		shoppingCart = getPayment().getShoppingCart();
		return shoppingCart.getProducts().containsKey(valid);
	}

	@Override
	public void useCoupon(IPayment payment) throws CouponNotValidException {
		
		if(!isValid())
			throw new CouponNotValidException();
		
		IProduct temp = new Product(valid.getPrize(), valid.getIdProduct(), valid.getName());
		temp.setPrize(getDiscount() * valid.getPrize());
		
		if (!shoppingCart.removeProduct(valid, 1))
			throw new CouponNotValidException();
		
		shoppingCart.addProduct(temp, 1);
	}


}
