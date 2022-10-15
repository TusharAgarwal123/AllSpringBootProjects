package com.stream.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain1 {

	public static void main(String[] args) {

		// create a list and filter all even numbers from list.

		// this method will create a list but this list is immutable we cannot add or
		// delete any no from it.
		List<Integer> l1 = List.of(2, 3, 4, 6, 8, 7, 78);

		// ll.add(12); it will return a runtime exception called
		// java.lang.UnsupportedOperationException

		// this will create a mutable list.
		List<Integer> l2 = new ArrayList<>();
		l2.add(2);
		l2.add(3);
		l2.add(4);
		l2.add(6);

		// this will create immutable list.

		List<Integer> l3 = Arrays.asList(2, 3, 4, 5);

		// l1
		// without stream
		List<Integer> l4 = new ArrayList<>();
		for (int x : l1) {
			if (x % 2 == 0) {
				l4.add(x);
			}
		}

		System.out.println(l1);
		System.out.println(l4);

		// using stream api.
		// stream is interface in java.

		// Stream<Integer> ss = l1.stream();
		List<Integer> l5 = l1.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.println(l5);

		// fetch all element which are smaller than 7.

		List<Integer> l6 = l1.stream().filter(i -> i < 7).collect(Collectors.toList());
		System.out.println(l6);

	}

}
