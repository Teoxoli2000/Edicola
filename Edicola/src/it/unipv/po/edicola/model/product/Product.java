package it.unipv.po.edicola.model.product;


public class Product implements IProduct {
	private Double prize;
	private Integer idProduct;
	private String name;
	
	
	public Product(Double prize, Integer idProduct, String name) {
		super();
		this.prize = prize;
		this.idProduct = idProduct;
		this.name = name;
	}

	@Override
	public Double getPrize() {
		return prize;
	}
	
	@Override
	public void setPrize(Double prize) {
		this.prize = prize;
	}
	
	@Override
	public Integer getIdProduct() {
		return idProduct;
	}
	
	@Override
	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Prodotto: " + getName() + " [" + getIdProduct() +"] " + getPrize() +"\n";
	}

	@Override
	public Boolean isEqual(IProduct product) {
		if (product.getIdProduct() != getIdProduct())
			return false;
		return true;
	}

}
