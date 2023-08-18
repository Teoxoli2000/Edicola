package it.unipv.po.edicola.model.accounting;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;

import it.unipv.po.edicola.model.market.payment.IPayment;

public class Accounting implements IAccounting{
	private HashSet<IPayment> entrances;
	private HashSet<IPayment> exits;
	private HashSet<IPayment> refunds;
	
	public Accounting() {
		super();
		this.entrances = new HashSet<IPayment>();
		this.exits = new HashSet<IPayment>();
		this.refunds = new HashSet<IPayment>();
	}
	
	@Override
	public HashSet<IPayment> getTransactions(LocalDateTime start, LocalDateTime end) {
		HashSet<IPayment> result  = new HashSet<IPayment>();
		for (IPayment p: entrances) {
			if (p.getDateTime().isAfter(start) && p.getDateTime().isBefore(end)) 
				result.add(p);
		}
		return result;
	}
	
	@Override
	public HashSet<IPayment> getTransactions(LocalDateTime start) {
		return getTransactions(start, LocalDateTime.now());
	}
	
	@Override
	public HashSet<IPayment> getTransactions() {
		LocalDateTime today = LocalDate.now().atStartOfDay();
		return getTransactions(today);
	}
	
	@Override
	public void addExit(IPayment p) {
		exits.add(p);
	}
	
	@Override
	public void removeExit(IPayment p) {
		exits.remove(p);
	}
	
	@Override
	public void addEntrance(IPayment p) {
		entrances.add(p);
	}
	
	@Override
	public void removeEntrance(IPayment p) {
		entrances.remove(p);
	}
	
	@Override
	public void addRefund(IPayment p) {
		refunds.add(p);
	}
	
	@Override
	public void removeRefund(IPayment p) {
		refunds.remove(p);
	}
	
	@Override
	public HashSet<IPayment> getEntrances() {
		return entrances;
	}

	@Override
	public void setEntrances(HashSet<IPayment> entrances) {
		this.entrances = entrances;
	}

	@Override
	public HashSet<IPayment> getExits() {
		return exits;
	}

	@Override
	public void setExits(HashSet<IPayment> exits) {
		this.exits = exits;
	}


	@Override
	public HashSet<IPayment> getRefunds() {
		return refunds;
	}

	@Override
	public void setRefunds(HashSet<IPayment> refunds) {
		this.refunds = refunds;
	}
	
}
