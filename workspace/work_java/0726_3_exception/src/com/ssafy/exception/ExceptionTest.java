package com.ssafy.exception;

import java.io.IOException;

public class ExceptionTest {
	public static void main(String[] args) throws InvalidValueException {
		
		System.out.println(MyUtil.readLog());
		
		//너 대비 안하니 .. compile이 안된다. -> try catch하던지, 던지던지 둘중 하나를 해라
		try {
			MyUtil.logging("오늘 하루도 고생 많았다리~");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(MyUtil.division(10, 0));
		} catch (InvalidValueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(MyUtil.division(10, 3));
		System.out.println("main end----------------");
	}
}
//main end가 안찍혔지? 복구가 되지 않고 바로 끝나버리는 거야,
//이게 바로 runtimeException

