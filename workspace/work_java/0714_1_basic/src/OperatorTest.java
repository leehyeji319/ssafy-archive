
public class OperatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i = 10;
//		int j = ++i; //i = i + 1; int j = i;
		int j = i++;
		System.out.println(i+","+j);
		
		int k = 10;
		System.out.println(k++);
		
		int a = 10;
		a += 1; //a++ ++a
	}

}
