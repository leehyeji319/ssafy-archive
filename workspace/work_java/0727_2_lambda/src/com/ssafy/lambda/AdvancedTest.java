package com.ssafy.lambda;

import java.util.Arrays;
import java.util.List;

public class AdvancedTest {
	public static void main(String[] args) {
		
		Integer[] arr = {3, 5, 1, 2, 7};
		//Arrays.sort() 얘는 Integer한테 그냥 물어보는거야
//		Arrays.sort(arr, new Comparator<Integer>() {
//			//여기가 definition 정의. comparator의 구현 내용을 넣으세요
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return o2-o1;
//			}
//			
//		}); //compareTo는 return int값을 준다. //얘는 final이라 못바꿈 -> 제 3자한테 줘야지 그게 바로 comparator 라는 Interface
	
		
		//==========람다식으로 바꾸기==========
		Arrays.sort(arr, (o1, o2) -> o2-o1); 
		System.out.println(Arrays.toString(arr));

		
		//asList라는 static메서드 (가변인자 라는 개념)
		List<Integer> list = Arrays.asList(10, 20, 30);
		
		//내가 반복을 돌리는게 아니라 foreach가 돌리는거임. forEach가 돌때마다 되는 행위를 줘야하잖아
		//그럼 메서드를 줘야하는데, 자바는 메서드 절대 못줌.. 객체를 줘야지~
		//consumer를 구현하는것
//		list.forEach(e -> {System.out.println(e);});
//		list.forEach(e -> System.out.println(e));
		list.forEach(System.out::println); //메소드 참조 //consumer의 accept과 같다 //메서드를 호출하는게 아님
	
	
		
		//람다는 익명객체표현 -> 메서드가 한개일때
	}

}
