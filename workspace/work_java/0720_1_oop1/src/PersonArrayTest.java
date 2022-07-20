import java.util.Arrays;

public class PersonArrayTest {

	public static void main(String[] args) {
		Person[] persons = new Person[2];
		System.out.println(Arrays.toString(persons)); // 배열을 만들었지, 배열의 원소 객체까지 만든건 아니다.
		// 실행결과: null, null

		persons[0] = new Person("김재환", 26);
		persons[1] = new Person("이동욱", 16);

		for (int i = 0; i < persons.length; i++) {
			persons[i].printInfo();
		}
		
		for (Person person : persons) {
			 person.printInfo();
		}
	}

}
