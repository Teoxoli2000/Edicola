package it.unipv.po.edicola.model.market;

import java.time.LocalDateTime;
import java.util.HashSet;

import it.unipv.po.edicola.model.market.payment.IPayment;

public interface IAccounting {
	public HashSet<IPayment> getTransactions(LocalDateTime start, LocalDateTime end);
	public HashSet<IPayment> getTransactions(LocalDateTime start);
	public HashSet<IPayment> getTransactions();
	
	public void addExit(IPayment p);
	public void removeExit(IPayment p);
	
	public void addEntrance(IPayment p);
	public void removeEntrance(IPayment p);
	
	public void addRefund(IPayment p);
	public void removeRefund(IPayment p);
	
	public HashSet<IPayment> getEntrances();
	public void setEntrances(HashSet<IPayment> entrances);
	public HashSet<IPayment> getExits();
	public void setExits(HashSet<IPayment> exits);
	public HashSet<IPayment> getRefunds();
	public void setRefunds(HashSet<IPayment> refunds);
	
	public Integer genereteIdPayment();

}
