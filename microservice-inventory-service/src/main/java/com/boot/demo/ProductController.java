package com.boot.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	List<Inventory> list = new ArrayList<>();

	@GetMapping("/inventory/{productId}")
	public Inventory getInventoryDetails(@PathVariable Long productId) {

		// get name and description from product-service.

		Inventory i = getInventoryInfo(productId);

		return i;
	}

	private Inventory getInventoryInfo(Long productId) {
		populateInventoryList();
		for (Inventory pi : list) {
			if (pi.getProductId() == productId) {
				return pi;
			}
		}
		return null;
	}

	private void populateInventoryList() {
		list.add(new Inventory(201L, 101L, true));
		list.add(new Inventory(202L, 102L, false));
		list.add(new Inventory(203L, 103L, true));

	}
}
