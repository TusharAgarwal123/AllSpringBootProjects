package com.boot.demo;

public class ProductInfo {

	private Long productId;
	private String productName;
	private String productDes;

	public ProductInfo() {
		// TODO Auto-generated constructor stub
	}

	public ProductInfo(Long productId, String productName, String productDes) {

		this.productId = productId;
		this.productName = productName;
		this.productDes = productDes;
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

}
