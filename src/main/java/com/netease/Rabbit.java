package com.netease;

public class Rabbit implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("rabbit run "+i+" steps!");
		}
	}

}
