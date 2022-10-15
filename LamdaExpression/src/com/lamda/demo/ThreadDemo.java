package com.lamda.demo;

public class ThreadDemo {

	public static void main(String[] args) {

		// this is thread 1
		Runnable r = () -> {

			for (int i = 1; i <= 10; i++) {
				System.out.println(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		};

		Thread t = new Thread(r);
		t.setName("JOHN");
		t.start();

		// This is thread 2
		Runnable r2 = () -> {

			for (int i = 1; i <= 10; i++) {
				System.out.println(i * 2);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		};

		Thread t2 = new Thread(r2);
		t2.start();
	}

}
