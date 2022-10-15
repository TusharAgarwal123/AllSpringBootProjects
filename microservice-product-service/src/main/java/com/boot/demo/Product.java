package com.boot.demo;

//@Data // it will generate getter and setter
//@NoArgsConstructor // it will generate no argument constructor
public class Product {

	private Long productId;
	private String productName;
	private String productDes;
	private Integer productPrice;
	private Boolean productStock;

	public Product() {

	}

	public Product(Long productId, String productName, String productDes, Integer productPrice, Boolean productStock) {

		this.productId = productId;
		this.productName = productName;
		this.productDes = productDes;
		this.productPrice = productPrice;
		this.productStock = productStock;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDes() {
		return productDes;
	}

	public void setProductDes(String productDes) {
		this.productDes = productDes;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	public Boolean getProductStock() {
		return productStock;
	}

	public void setProductStock(Boolean productStock) {
		this.productStock = productStock;
	}

}
