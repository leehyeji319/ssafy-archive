
public class DateTypeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int price = 100000000;
//		int amount = 30;
//		long totalPrice = price * amount;
//		System.out.println(totalPrice);
//		long price = 100000000; // long = int ==> long = long
//		int amount = 30;
//		long totalPrice = price * amount; // long * int ==> long * long
//		System.out.println(totalPrice);

		int price = 100000000;
		int amount = 30;
		long totalPrice = (long)price * amount;
		System.out.println(totalPrice);
		
		int sum = 100;
		int cnt = 3;
		//double avg = sum/cnt; // int/int => int double = int, double = double
		double avg = (double)sum/cnt; //double/int =>double.double ==> double
 		System.out.println(avg);
		System.out.printf("%.2f\n", avg);
		
		double rate = 10.456;
		System.out.printf("%.2f%%\n", rate);
	}

}
