package com.ssafy.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class S1_BasicTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] arr = {"김재환", "강태오", "박은빈"};
		List<String> list = Arrays.asList(arr);
		
		//오름차순 정렬 후 모든 원소 출력 
		Arrays.sort(arr);
		for (String s : list) {
			System.out.println(s);
		}
		
		//list는 배열이 아님 하지만내부적으로 배열을 쓰긴함
		Collections.sort(list);
		for (String s : list) {
			System.out.println(s);
		}
		
		System.out.println("==========================");
		
		//stream은 static method
		//원본에 영향없음 sorted
		// return이 stream이면 중간연산이고, 스트림이 아니면 최종연산이지.
		Arrays.stream(arr).sorted().forEach(System.out::println);
		list.stream().sorted().forEach(System.out::println); //내부반복
		System.out.println(Arrays.toString(arr));
	}

}
