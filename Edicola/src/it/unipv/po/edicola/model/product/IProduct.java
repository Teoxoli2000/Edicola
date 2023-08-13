package it.unipv.po.edicola.model.product;


public interface IProduct {
	public Double getPrize();
	public void setPrize(Double prize);
	
	public Integer getIdProduct();
	public void setIdProduct(Integer id);
	
	public String getName();
	public void setName(String name);
	
	public Boolean isEqual(IProduct product);
	
}
