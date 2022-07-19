import java.util.Arrays;
import java.util.Scanner;

public class SearchDirectionTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int R = sc.nextInt();
		int C = sc.nextInt();

		int[][] arr = new int[N][N];

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		int nr, nc;
		
		for (int d = 0, dSize = dr.length; d < dSize; d++) {
			nr = R + dr[d];
			nc = C + dc[d];
			//경계값체크 
			if (nr >= 0 && nc >= 0 && nr < N && nc < N) arr[nr][nc] = 2;
		}
		

		// 델타값 없는값
		if (R - 1 >= 0)
			arr[R - 1][C] = 2;
		if (R + 1 < N)
			arr[R + 1][C] = 2;
		if (C - 1 >= 0)
			arr[R][C - 1] = 2;
		if (C + 1 < N)
			arr[R][C + 1] = 2;

		for (int[] is : arr) {
			System.out.println(Arrays.toString(is));
		}
	}

}
