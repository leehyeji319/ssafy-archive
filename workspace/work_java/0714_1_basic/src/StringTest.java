
public class StringTest {

	public static void main(String[] args) {
		
		String s1 = "hi";
		String s2 = "hi";
		String s3 = new String("hi"); //생성방법차이점
		
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println(s2==s3);

	}

}
