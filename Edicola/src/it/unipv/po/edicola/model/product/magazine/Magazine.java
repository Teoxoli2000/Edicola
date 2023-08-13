package it.unipv.po.edicola.model.product.magazine;

import java.time.LocalDate;

import it.unipv.po.edicola.model.product.Product;

public class Magazine extends Product implements IMagazine {
	private LocalDate date;
	private String period;
	
	public Magazine(Double prize, Integer idProduct, String name, LocalDate date, String period) {
		super(prize, idProduct, name);
		this.date = date;
		this.period = period;
	}

	@Override
	public LocalDate getDate() {
		return date;
	}

	@Override
	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String getPeriod() {
		return period;
	}

	@Override
	public void setPeriod(String period) {
		this.period = period;
	}

	@Override
	public String toString() {
		return "Prodotto: " + getName() + " [" + getIdProduct() +"] " + getPrize() + "\n" +
				"Pubblicato il: " + getDate().toString() +"\n"
				+"Tipo: " + getPeriod()+"\n";
	}
}
