package com.netease;

public class Tortoise implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("tortoise run "+i+" steps!");
		}
	}

}
