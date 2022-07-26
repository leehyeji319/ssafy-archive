package com.ssafy.live2.extend.person;

public class SpiderMan extends Person{
	
	boolean isSpider;
	Spider spider = new Spider();
	
	SpiderMan(String name, boolean isSpider) {
		//this() or super()가 올 수 있는 아무것도 없으면 누가 생략?
		super(name);
		this.isSpider = isSpider;
	}
	void fireWeb() {
		if (isSpider) {
			spider.fireWeb();
			
		} else {
			System.out.println("사람일때는 참자");
		}
	}

}
