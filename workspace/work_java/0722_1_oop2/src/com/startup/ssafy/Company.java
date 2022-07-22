package com.startup.ssafy;

public class Company {
	
	private String name;
	
	//======매개변수의 다형성=======//
	
//	public void increaseSalary(Object e) {
//		
//	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName(String name) {
		return name;
	}
	
	
	public void increaseSalary(Employee e) {
		e.salary += 5000000;
		if (e instanceof Engineer) { //e가 Engineer로부터 파생된애가 맞습니까??
			Engineer eg = (Engineer) e; //문법적인 문제는 없지만 논리적인 문제가있다.
			eg.skill += ", AI";			
		}
		System.out.println(name + "회사 직원 : " + e.getInformation());
	}
	
//	public void increaseSalary(Manager e) {
//		e.salary += 5000000;
//		System.out.println(name + "회사 직원 : " + e.getInformation());
//	}
}
