package com.ssafy.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.ssafy.stream.Person;

public class S2_OperationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Stream<String> names = Stream.of("john", "tomas", "jane", "smith");
		String[] arr = {"john", "tomas", "jane", "smith"};
		//지역변수
		
		{
			Stream<String> names = Arrays.stream(arr);
			//이름에s가 들어있는 사람들만 추출해서 몇명인지출력해라
			long count = names.filter(e -> e.contains("s")).count();
			
			System.out.println(count);
		}
		{
			//이름뒤에 's를 붙이는 가공 후에 모두 출력
//			Arrays.map(e -> e.concat("'s")).forEach(System.out::println);
			Arrays.stream(arr).map(e -> e.concat("'s")).forEach(System.out::println);
		
			//stream은 나르는 애고 데이터를 가지고있는 애가 아님. 입력데이터들을 다 사용하면, 얘는 이제 사용 못해
		}
		System.out.println("======================");
		{
			//이름에 s가 들어있는 사람들만 추출해서 이름뒤에 's를 붙이는 가공후 모두 출력
			Arrays.stream(arr).filter(e -> e.contains("s"))
				.map(e -> e.concat("'s")).forEach(System.out::println);
		}
		
		{
			Person persons[] = {new Person("김재환", 27), new Person("박보", 30), new Person("이동", 16)};
			
			int sum = Arrays.stream(persons).mapToInt(e -> e.age).sum(); //sum이 최종연산
			System.out.println(sum);
			
			//getAsInt() 값을 꺼낼 수 있음
			int max = Arrays.stream(persons).mapToInt(e -> e.age).max().getAsInt(); 
			
			//나이가 20세 이상인 사람들의 리스트를 반환 //collector ? 어떻게 모을까요 ~
			List<Person> result = Stream.of(persons).filter(e -> e.age >= 20).collect(Collectors.toList());
			result.forEach(System.out::println);
			
			//mapping이 가공말고도 추출하는걸로도 사용할 수있어야함
			List<String> names = Stream.of(persons)
					.filter(e -> e.age >= 20).map(e -> e.name)
					.collect(Collectors.toList());
			result.forEach(System.out::println);
		}
	
	}

}
