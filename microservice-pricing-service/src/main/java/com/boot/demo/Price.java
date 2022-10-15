package com.boot.demo;

public class Price {

	private Long priceId;
	private Long productId;
	private Integer OriginalPrice;
	private Integer DiscountedPrice;

	public Price() {
		// TODO Auto-generated constructor stub
	}

	public Price(Long priceId, Long productId, Integer originalPrice, Integer discountedPrice) {

		this.priceId = priceId;
		this.productId = productId;
		OriginalPrice = originalPrice;
		DiscountedPrice = discountedPrice;
	}

	public Long getPriceId() {
		return priceId;
	}

	public void setPriceId(Long priceId) {
		this.priceId = priceId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getOriginalPrice() {
		return OriginalPrice;
	}

	public void setOriginalPrice(Integer originalPrice) {
		OriginalPrice = originalPrice;
	}

	public Integer getDiscountedPrice() {
		return DiscountedPrice;
	}

	public void setDiscountedPrice(Integer discountedPrice) {
		DiscountedPrice = discountedPrice;
	}

}
