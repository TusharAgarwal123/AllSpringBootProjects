package com.boot.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductController {

	@Autowired
	private RestTemplate rt;

	List<ProductInfo> list = new ArrayList<>();

	@GetMapping("/product/details/{productId}")
	public Product getProductDetails(@PathVariable Long productId) {

		// get name and description from product-service.

		ProductInfo pi = getProductInfo(productId);

		// get price from pricing-service
		// it is accessing the microservice-pricing-service project
		Price pp = rt.getForObject("http://localhost:8001/price/" + productId, Price.class);

		// get stock availablity from inventory-service
		// it is accessing the microservice-inventory-service project
		Inventory ii = rt.getForObject("http://localhost:8002/inventory/" + productId, Inventory.class);

		return new Product(pi.getProductId(), pi.getProductName(), pi.getProductDes(), pp.getDiscountedPrice(),
				ii.getInStock());
	}

	private ProductInfo getProductInfo(Long productId) {
		populateProductList();
		for (ProductInfo pi : list) {
			if (pi.getProductId() == productId) {
				return pi;
			}
		}
		return null;
	}

	private void populateProductList() {
		list.add(new ProductInfo(101L, "iPhone", "phone is damn expensive"));
		list.add(new ProductInfo(102L, "realMe", "phone is damn cheap"));
		list.add(new ProductInfo(103L, "samsung", "phone is normal"));

	}
}
