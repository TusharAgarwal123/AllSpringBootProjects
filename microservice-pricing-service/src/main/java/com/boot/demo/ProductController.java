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

	List<Price> list = new ArrayList<>();

	@GetMapping("/price/{productId}")
	public Price getPriceDetails(@PathVariable Long productId) {

		// get name and description from product-service.

		Price p = getPriceInfo(productId);

		// currnecy-exchnage microservice
		Integer val = rt.getForObject("http://localhost:8003/currexg/from/USD/to/INR", ExchangeValue.class)
				.getExchangeValue();

		return new Price(p.getPriceId(), p.getProductId(), p.getOriginalPrice(),
				Math.multiplyExact(val, p.getDiscountedPrice()));
	}

	private Price getPriceInfo(Long productId) {
		populatePriceList();
		for (Price pi : list) {
			if (pi.getProductId() == productId) {
				return pi;
			}
		}
		return null;
	}

	private void populatePriceList() {
		list.add(new Price(301L, 101L, 10000, 160));
		list.add(new Price(302L, 102L, 15000, 100));
		list.add(new Price(303L, 103L, 100000, 1700));

	}
}
