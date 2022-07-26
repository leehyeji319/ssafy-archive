
public class Person {
	
	private String name;
	private int age;
	private static int totalCnt; //class변수 
	private int order; //instance변수 
	
	
	//나의 생성자를 부르는 코드는 항상 첫번째에 와야함 !!!!!!!!!!!!!
	
	public Person(String name, int age) {
		//this.name = name;
		//new Person(name); //이렇게 되면 나는 객체를 또 만드는거임 이러면 안되지?
		//그러면 어떻게 해야할까?
		this(name);
		this.age = age;
		System.out.println("Person(String name, int age)");
	}
	
	public Person(String name) { //생성자코드를 마치 메소드처럼 불러서 초기화를 함
		//아무데서나 this쓰면 안된다.
		this.name = name;
		//this.order = ++totalCnt;
		order = ++totalCnt;
	}
	
	//static initializer
	static {
		totalCnt = 0;
		System.out.println("static initializer...");
	}
	
	{
		System.out.println("init...");
	}

	Person increaseAge() { //Person 주는거랑 똑같은걸로  
		//static일 수 가없는 이유: 나이에 접근해야하는데 사람이없는데 어케접근해,
		//or누구꺼 나이를 하는지 알수 가없으니까
		this.age++;
		return this;
	}
	
	void printInfo() {
		System.out.println(order + "/" + totalCnt + ": " + name + ", " + age);

		//중간과정에 불필요한 문자열ㅇ르 생성하지 않게 
		//Buffered등등 사용..
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static int getTotalCnt() {
		return totalCnt;
	}


	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	
	
}
