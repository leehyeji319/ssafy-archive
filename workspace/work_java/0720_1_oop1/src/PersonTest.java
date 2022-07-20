
public class PersonTest {

	public static void main(String[] args) {
		
		//처음부터 주문해서 내가 원하는 대로 받은거임
		Person p1 = new Person("김재환", 26);
//		p1.name = "김재환";
//		p1.age = 26;
		
		Person p2 = new Person("이동욱", 16);
//		p2.name = "이동욱";
//		p2.age = 16;
		
		//이름만 알경우에는?
		Person p3 = new Person("김철수");
		
		p1.printInfo();
		p2.printInfo();
		p3.printInfo(); //default 초기값으로 되니까 0이 나온다.
		
		p1.increaseAge();
		p1.increaseAge();
		p2.increaseAge().increaseAge(); //연쇄적인 메서드 호출을 할 수 있다.
		//return this많이 씀
		//StringBuilder, StringBuffer가 있다.
		 
		p1.printInfo();
		p2.printInfo();
	}

}

