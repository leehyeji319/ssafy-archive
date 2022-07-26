

//직원이니까 is a 관계
//클래스 상속: 부모를 확장하여 새로운 내용을 덧붙이거나 기존내용을 변경하는 것
public class Engineer extends Employee {
	String skill;

	public Engineer(String name, int salary, String skill) {
		super(name, salary);
		this.skill = skill;
	}
	
//	String getInfo() {
//		return getInformation() + ", skill: " + skill;
//	}
//	
	String getInformation() {
		return super.getInformation() + ", skill: " + skill;
		//super를 안붙이면 stackoverflow가 일어나서 죽는다. ..  ....
		//내가 정의한것과 부모꺼가 구분하려고..
		//재정의한건 항상 자식이 우선이기때문에 부모가 호출되지않아서 super를 붙여야됨
		
	}
}
