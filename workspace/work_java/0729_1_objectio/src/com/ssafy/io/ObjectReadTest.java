package com.ssafy.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectReadTest {

	public static void main(String[] args) {
//try read resources 면 자동으로 클로즈가 된다.
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.dat"))) {
			Person p = (Person)in.readObject(); //강제 형변환
			System.out.println(p);
		} catch(Exception e) {
			e.printStackTrace();			
		}
	}
//stream은 close될때 flush된다.
	//buffer를 쓰는 이유 같이할라고
	//직렬화에서 제외하려는 멤버는 transient선언
}
