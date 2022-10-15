package com.lamda.demo;

public class Demo {

	public static void main(String[] args) {

		System.out.println("Hello world");

		// this is implementation using anonymous class
		/*
		 * MyInter i = new MyInter() {
		 * 
		 * @Override public void sayHello() {
		 * System.out.println("This is first anonymous class!!");
		 * 
		 * }
		 * 
		 * }; i.sayHello();
		 */

		// using our interface with the help of lamda.

		MyInter i = () -> {
			System.out.println("This is first time we are using lamda!!");
		};

		i.sayHello();

		MyInter i2 = () -> System.out.println("This is second time we are using lamda!!");

		i2.sayHello();

		SumInter s1 = (int a, int b) -> {
			return a + b;

		};

		System.out.println(s1.add(12, 6));

	}

}
