package it.unipv.po.edicola.model.product.magazine;

import java.time.LocalDate;

import it.unipv.po.edicola.model.product.IProduct;


public interface IMagazine extends IProduct {
	public LocalDate getDate();
	public void setDate(LocalDate date);
	
	public String getPeriod();
	public void setPeriod(String period);
}
