package com.startup.ssafy;
//상위클래스
public class Employee extends Object{
	
	String name;
	int salary;
	
	
	
	public Employee(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	

	void work() {
		System.out.println("일을 합니다.");
	}
	
	String getInformation() {
		StringBuilder sb = new StringBuilder();
		return sb.append("이름: ") .append(name).append(", 연봉: ")
				.append(salary).toString();
		
	}
}
