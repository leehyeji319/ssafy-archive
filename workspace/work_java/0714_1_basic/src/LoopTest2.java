
public class LoopTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1부터10까지 홀수의 누적합

		int sum = 0;
		for (int i = 1; i <= 10; ++i) {
			if (i % 2 == 0)
				continue;
			sum += i;
		}

		System.out.println(sum);

		int i = 0;
		int sum2 = 0;
		while (++i < 11) {
			if (i % 2 == 0) {
				continue;
			} else {
				sum2 += i;
			}
		}

		System.out.println(sum2);
	}

}