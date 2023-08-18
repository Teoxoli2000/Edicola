package it.unipv.po.edicola.model.market.payment;

import java.time.LocalDateTime;

import it.unipv.po.edicola.model.exception.LocationNotFoundException;
import it.unipv.po.edicola.model.exception.ProductNotFoundException;
import it.unipv.po.edicola.model.shop.ILocation;
import it.unipv.po.edicola.model.shop.INewsstand;


public interface IPayment {
	public void changeNewsstandInventory(INewsstand newsstand, ILocation location) 
			throws LocationNotFoundException, ProductNotFoundException;
	public void changeNewsstandAccounting(INewsstand newsstand);

	public Double calculateTotal();
	
	public ILocation getShoppingCart();
	public void setShoppingCart(ILocation cart);
	
	public Double getTotal();
	public void setTotal(Double temp);
	
	public Integer getPaymentId();
	public void setPaymentId(Integer id);
	
	public LocalDateTime getDateTime();
	public void setDateTime(LocalDateTime dateTime);
	
}
