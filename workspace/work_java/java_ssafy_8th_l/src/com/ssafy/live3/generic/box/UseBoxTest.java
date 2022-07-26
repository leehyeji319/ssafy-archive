package com.ssafy.live3.generic.box;

public class UseBoxTest {

    public static void main(String[] args) {
        useNormalBox();
        useGenericBox();
        useNumberBox();
    }

    private static void useNormalBox() {
        // TODO: NormalBox 타입의 객체를 생성하고 사용해보세요.
    	NormalBox nbox = new NormalBox();
    	// Object 처리 --> 뭐든지 담을 수 있다.
    	nbox.setSome(1);
    	nbox.setSome("hello");
    	
    	//Object밖에 못써.. 
    	Object obj = nbox.getSome();
    	//compile ok, runtime error - runtime에 타입에 체크
    	//Integer num = (Integer)obj; //이렇게 바로 하면 문제가 잇지 !! if문으로 확인해줘야지
    	if (obj instanceof String) {
    		String str = (String)obj;
    		System.out.println(str + " : " + str.length());
    	}
    	
    	
        // END:
    }

    private static void useGenericBox() {
        // TODO: GenericBox 타입의 객체를 생성하고 사용해보세요.
    	GenericBox<String> sbox = new GenericBox<>();
    	sbox.setSome("Hello");
    	//sbox.setSome(1);
    	String str = sbox.getSome();
    	System.out.println(str + " : " + str.length());
        // END:
    }

    private static void useNumberBox() {
        // TODO: NumberBox 타입의 객체를 생성하고 사용해보세요.
        // END:
    }

}
