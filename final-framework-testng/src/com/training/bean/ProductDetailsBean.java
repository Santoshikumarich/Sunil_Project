package com.training.bean;

public class ProductDetailsBean {
	
	private String ProductName;
	private String MetaTagTitle;
	private String Model;
	private String Price;
	private String Quantity;
	private String Category;
	
	public ProductDetailsBean() {
	}

	public ProductDetailsBean(String ProductName, String MetaTagTitle, String Price, String Model, String Quantity,String Category  ) {
		super();
		this.ProductName = ProductName;
		this.MetaTagTitle = MetaTagTitle;
		this.Price = Price;
		this.Price = Model;
		this.Price = Quantity;
		this.Price = Category;
	
		
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public String getMetaTagTitle() {
		return MetaTagTitle;
	}

	public void setMetaTagTitle(String metaTagTitle) {
		MetaTagTitle = metaTagTitle;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public String getQuantity() {
		return Quantity;
	}

	public void setQuantity(String quantity) {
		Quantity = quantity;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	@Override
	public String toString() {
		return "ProductDetailsBean [ProductName=" + ProductName + ", MetaTagTitle=" + MetaTagTitle + ", Price=" + Price + ", Model=" + Model + ", Quantity=" + Quantity + ", Category=" + Category + "]";
	}

}
