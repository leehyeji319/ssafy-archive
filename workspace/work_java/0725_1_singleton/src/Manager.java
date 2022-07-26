

public class Manager extends Employee {

	String dept;
	
	
	
	public Manager(String name, int salary, String dept) {
		super(name, salary);
		this.dept = dept;
	}



	void managing() {
		System.out.println(dept+"부서 직원들을 관리합니다.");
	}
}
