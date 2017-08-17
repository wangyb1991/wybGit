package com.netease;

public class ThreadTest {
	public static void main(String[] args) {
		Rabbit r = new Rabbit();
		Tortoise tt = new Tortoise();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(tt);
		t1.start();
		t2.start();
		for (int i = 0; i < 100; i++) {
			System.out.println("main run "+i+" steps!");
		}
	}
}
