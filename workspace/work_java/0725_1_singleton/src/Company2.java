//디자인패턴 : 설계패턴(설계 레시피) 
//싱글톤디자인패턴: 객체를 1개만 유지하도록 하는패턴
//				클래스 내부에서 객체를 딱 1번만 생성후객체의 래퍼런스 제공 

//							private static
//1. 생성자의 외부 접근을 막기 : private
//2. 참조값을 제공해주는 getter작성
// getter 메소드 안에서 객체 생성이 안되어 있을 경우메만 생성 후 리턴
//장점: lazy loading
//단점: multi thread unsafe

public class Company2 {
	
		//======매개변수의 다형성=======//
	
//	public void increaseSalary(Object e) {
//		
//	}
	
	private String name;
	
	//=====singleton=====//
	private static Company2 instance;
	
	private Company2() {
		
	}
	
	public static Company2 getInstance() {
		if (instance == null) { // t1, t2
			instance = new Company2(); //t2, t1
		}
		instance = new Company2();
		return instance;
	}
	
	//===================//
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
