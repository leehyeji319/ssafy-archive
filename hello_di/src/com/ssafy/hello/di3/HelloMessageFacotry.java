package com.ssafy.hello.di3;

public class HelloMessageFacotry {
	
	public static HelloMessage getHelloMessage(String lang) {
		if("kor".equals(lang)) {
			return new HelloMessageKor();
		} else {
			return new HelloMessageEng();
		}
	}

}
