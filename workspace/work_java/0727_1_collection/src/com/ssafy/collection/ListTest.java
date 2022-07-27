package com.ssafy.collection;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList();
		list.add("Hello"); //Hello
		list.add("SSAFY"); //Hello , SSAFY
//		list.add(10); //Hello, SSAFY, 10
//		list.add(new Integer(10)); // Hello, SSAFY, 10
		if (!list.contains("Hello")) list.add("Hello"); //Hello , SSAFY , 10 , Hello
		list.add(1, "서울 9반"); //Hello, 서울 9반, SSAFY, 10, Hello
	
//		for (int i = 0, size = list.size(); i < size; i++) {
//			String o = list.get(i);
////			String o = (String) list.get(i); //우변은 오브젝트타입
//			System.out.println(o);
//		}
		
		for (String o : list) {
			System.out.println(o);
		}
		
		list.remove(0);
		
		System.out.println("=======0삭제=======");
		for (String o : list) {
			System.out.println(o);
		}
	}
}
