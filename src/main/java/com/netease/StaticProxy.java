package com.netease;

/**
 * @author wangyanbo
 * 代理模式（You类为本体，WeddingCompany为代理，实现共同的接口）
 *
 */
public class StaticProxy {
	public static void main(String[] args) {
		Marry y = new You();
		Marry wc = new WeddingCompany(y);
		wc.marry();
	}
}

interface Marry {
	void marry();
}

class You implements Marry {
	@Override
	public void marry() {
		System.out.println("you married!");
	}
}

class WeddingCompany implements Marry {
	private Marry you;
	
	
	public WeddingCompany() {
		
	}
	public WeddingCompany(Marry you) {
		this.you = you;
	}
	public void before() {
		System.out.println("buy a house");
	}
	public void after() {
		System.out.println("raise your child");
	}
	@Override
	public void marry() {
		// TODO Auto-generated method stub
		before();
		you.marry();
		after();
	}
}