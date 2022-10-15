package com.stream.demo;

import java.util.stream.Stream;

public class StreamObject {

	public static void main(String[] args) {

		// create blank stream.
		// 1.
		Stream<Object> ss = Stream.empty();

//		ss.forEach(e -> {
//
//			System.out.println(e);
//
//		});

		String names[] = { "Tushar", "Agarwal", "Rohit", "Sharma" };

		Stream<String> s = Stream.of(names);
		s.forEach(e -> {
			System.out.println(e);
		});

	}

}
