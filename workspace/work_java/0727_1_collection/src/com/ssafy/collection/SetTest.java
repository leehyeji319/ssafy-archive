package com.ssafy.collection;

import java.util.*;

public class SetTest {
	public static void main(String[] args) {
		
//		HashSet<String> set = new HashSet<>();
		TreeSet<String> set = new TreeSet<>();
		set.add("우영우");
		set.add("이준호");
		set.add("김재환");
		set.add("김재환");
		
		System.out.println(set.size());
		
		//set은 그냥 그 자체를 지우는거야, set은 키나 인덱스가 없어서 꺼내는 메서드가 없다.
		//set.remove(null);
		
		//set은 인덱스나 키가 없어서 꺼낸느 메서드가 없는 대신 이터레이터라는게 있다.
//		Iterator<String> it = set.iterator();
//		//다음 .. 다음 ~ hasNext가 트루일동안 계속 돌려돌려~  
////		it.hasNext();
//		
//		while (it.hasNext()) {
//			String s = it.next();
//			System.out.println(s);
//		}
//		
		for (String s : set) { //iterator
			System.out.println(s);
		}
	}
}
