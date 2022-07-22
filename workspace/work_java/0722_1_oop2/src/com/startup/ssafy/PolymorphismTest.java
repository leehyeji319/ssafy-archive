package com.startup.ssafy;

public class PolymorphismTest {

	public static void main(String[] args) {
//		Engineer eg = new Engineer("김싸피", 10000000,"Java");
//		Employee eg = new Engineer("김싸피", 10000000, "Java"); //얘는 임플로이니까 못한다는것임
		
//		eg.skill += ",Algorithm"; //Engineer
//		eg.salary += 100000000; //Employee
//		System.out.println(eg.toString()); //Object
	
//		Employee eg = new Engineer("김싸피", 1000000, "Java");
		Employee eg = new Manager("김태희", 20000000, "혁신개발1팀");
		
		System.out.println(eg.getInformation());
		//em.coding(); // 타일에 정의되지 않은 일은 할 수 없다.
		
		System.out.println("=====================");
		
		
		//====배열의 이형집합======//
		Employee[] employees = new Employee[2];
//		Object[] employees = new employee[2];
		employees[0] = new Engineer("김싸피", 10000000, "Java"); //Employee = Engineer
		employees[1] = new Manager("김태희", 20000000, "혁신개발1팀");
		
		//
		for (Employee employee : employees) {
			System.out.println(employee.getInformation()); //동적바인딩을 기대하고 하는것
		}
		
		
		System.out.println("=====================");
		Company cp = new Company();
		cp.setName("SSAFY");
		
		Engineer eg1 = new Engineer("김싸피", 10000000,"Java");
		Manager m1 = new Manager("김싸피", 10000000, "Java");
		
		System.out.println(eg1.getInformation());
		System.out.println(m1.getInformation());
		
		cp.increaseSalary(eg1);
		cp.increaseSalary(m1);
	}

}
