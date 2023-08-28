package it.unipv.po.edicola.mapper.accounting;

import java.time.LocalDateTime;
import java.util.HashSet;

import it.unipv.po.edicola.model.market.payment.IPayment;
import it.unipv.po.edicola.model.market.payment.Payment;

public interface IAccountingMapper {
	public HashSet<Payment> getAccountig(LocalDateTime date);
	public HashSet<Payment> getAccountig();
	
	public Boolean addPayment(IPayment payment);
	public Boolean removePayment(IPayment payment);
}
