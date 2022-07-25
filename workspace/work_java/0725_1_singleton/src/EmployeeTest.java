

public class EmployeeTest {

	public static void main(String[] args) {
		
		Engineer eg = new Engineer("이혜지", 100000000, "java");
		Manager m = new Manager("김태희", 200000000, "혁신개발1팀");
		
		eg.getInformation();
		System.out.println(eg.getInformation());
		System.out.println(m.getInformation());
	}

}
