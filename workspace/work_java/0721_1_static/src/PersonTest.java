
public class PersonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("총 사람수 : " + Person.getTotalCnt());
		
		Person p1 = new Person("이혜지", 23);
		
		System.out.println(p1.getOrder());
		
		Person p2 = new Person("김재환", 26);
		System.out.println(p2.getOrder());
		Person p3 = new Person("이동욱", 1);
		System.out.println(p3.getOrder());
		
		p3.setOrder(1);
		
		p1.printInfo();
		p2.printInfo();
		p3.printInfo();
	}

}
