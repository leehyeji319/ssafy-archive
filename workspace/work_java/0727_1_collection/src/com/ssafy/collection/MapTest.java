package com.ssafy.collection;
import java.util.*;

public class MapTest {
	
	public static void main(String[] args) {
		
		HashMap<Integer, String> map = new HashMap<>();
		map.put(111, "김재환");
		map.put(222, "우영우");
		map.put(333, "이준호");
		
		System.out.println(map.get(Integer.valueOf(111)));
		System.out.println(map.get(222));
		
		map.put(222, "박은빈");
		System.out.println(map.get(222));
		
		System.out.println("======================");
		
		Set<Integer> keys = map.keySet();
		for (Integer key : keys) {
			System.out.println(key + " : " + map.get(key));
		}
		System.out.println("===================");
		Collection<String> values = map.values(); //Collection 신경쓰지마
		
		for (String value : values) {
			System.out.println(value);
		}
		
		map.remove(222);
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			Integer key = entry.getKey();
			String val = entry.getValue();
			System.out.println(key + "::" + val);
			
		}
	}
	
	
}
