package com.ssafy.io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectWriteTest {

	public static void main(String[] args) {
//try read resources 면 자동으로 클로즈가 된다.
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.dat"))) {
			out.writeObject(new Person("김재환", 27, new Friend("김태희")));
			out.flush();
		} catch(Exception e) {
			e.printStackTrace();			
		}
	}
//stream은 close될때 flush된다.
	//buffer를 쓰는 이유 같이할라고
	//직렬화에서 제외하려는 멤버는 transient선언
}
