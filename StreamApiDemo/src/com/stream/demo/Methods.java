package com.stream.demo;

import java.util.List;
import java.util.stream.Collectors;

public class Methods {

	public static void main(String[] args) {

		// filter(predicate)
		// predicate is boolean value function.
		// e->{e>10}

		// map(Funcion) method

		List<String> names = List.of("Aman", "Tushar", "Agarwal", "Rohit", "Sharma");
		// List<String> ans = names.stream().filter(e ->
		// e.startsWith("A")).collect(Collectors.toList());

		// this will return string whose length is 5.
		List<String> ans = names.stream().filter(e -> {
			if (e.length() == 5) {
				return true;
			}
			return false;
		}).collect(Collectors.toList());

		System.out.println(ans);

		// square each no and return.
		List<Integer> number = List.of(2, 4, 5, 7, 6);

		List<Integer> no = number.stream().map(e -> e * e).collect(Collectors.toList());
		System.out.println(no);

		no.stream().sorted().forEach(System.out::println);
	}

}
