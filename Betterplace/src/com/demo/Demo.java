package com.demo;

public class Demo {

	String name;

	public Demo() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		Demo d = new Demo();
		d.setName("आप कैसे हैं");

		Demo dd = new Demo();
		dd.setName("तुषार");

		String s1 = d.getName();
		String s2 = dd.getName();

		Demo ddd = new Demo();
		ddd.setName(s1 + "     " + s2);
		System.out.println(ddd.getName());
	}

}
