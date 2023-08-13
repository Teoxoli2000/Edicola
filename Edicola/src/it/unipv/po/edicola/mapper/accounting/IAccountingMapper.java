package it.unipv.po.edicola.mapper.accounting;

import java.time.LocalDateTime;
import java.util.HashSet;

import it.unipv.po.edicola.model.market.payment.Payment;

public interface IAccountingMapper {
	public HashSet<Payment> getAccountig(LocalDateTime date);
	public HashSet<Payment> getAccountig();
	
	public Boolean addPayment(Payment entrance);
	public Boolean removePayment(Payment entrance);
}
