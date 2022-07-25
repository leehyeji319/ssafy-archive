//디자인패턴 : 설계패턴(설계 레시피) 
//싱글톤디자인패턴: 객체를 1개만 유지하도록 하는패턴
//				클래스 내부에서 객체를 딱 1번만 생성후객체의 래퍼런스 제공 

//							private static
//1. 생성자의 외부 접근을 막기 : private
//2. 참조값을 제공해주는 getter작성
//3. 객체 생성 여부 부분에서 multi threading시 자원공유 문제가 발생하므로 동기화 처리


// getter 메소드 안에서 객체 생성이 안되어 있을 경우메만 생성 후 리턴
//장점: lazy loading, multi thread unsafe, single thread 상황

public class Company4 {
	
		//======매개변수의 다형성=======//
	
//	public void increaseSalary(Object e) {
//		
//	}
	
	private String name;
	
	//=====singleton=====//
	//누군가 사용중이라면 알게끔
	private static Company4 instance;
	
	private Company4() {
		
	}
	
	public static Company4 getInstance() { 
		//이 메서드를 실행할때부터 임계영역설정이된다.
		if (instance == null) {
			synchronized (Company4.class) { // t1, t2
				if (instance == null) { // t1
					instance = new Company4();
				}
			}// release key //synchronized 끝나면 키가 리턴된다.
		}
		
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
