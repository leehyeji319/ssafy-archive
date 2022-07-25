package com.ssafy.live2.modifier.singleton;

class SingletonClass{
    // TODO:SingletonClass에 Singleton Design Pattern을 적용하시오.
	//멤버변수를 가지고 있지 않고기능만 있는 클래스: stateless한 클래스 - 상태를 가지지 않고 기능만 !
	
	private static SingletonClass sc = new SingletonClass(); //얘도 숨겨줘
	private SingletonClass() { }//생성자를 숨겨 ->밖에선 접근 못하게.. 무조건 private 
	
	// 우리는 게터만 잇으면 됨
	public static SingletonClass getSingletonCalss() {
		return sc; //얘도 올려야됨 메모리에 없으니까.. 
	}
    // END:
    public void sayHello() {
      System.out.println("Hello");
    }
    
  }

  public class SingletonTest {
    public static void main(String[] args) {
      // TODO:SingletonClass를 사용해보세요.  
    	//SingletonClass sc = new SingletonClass();
    	SingletonClass sc = SingletonClass.getSingletonCalss();
    	sc.sayHello();
    	
    	SingletonClass sc2 = SingletonClass.getSingletonCalss();
    	sc2.sayHello();
   
    	
    	System.out.println(sc == sc2);
      // END:
    }
  }
