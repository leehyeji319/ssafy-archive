import java.util.Arrays;
import java.util.Scanner;

public class CharMultiDimensionArrayTest {

	
	// 한 반의 학생들(5명)의 학점점수가 문자열로 입력 (ABCAA)
	// 총3반이 입력
	// 모든 반의 학생으 ㅣ학점정보를 캐릭터 배열로 char[][]
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = 3;
		//char[][] grades = new char[n][5];
		char[][] grades = new char[n][];
		
		for (int i = 0; i < n; i++) {
			grades[i] = sc.nextLine().toCharArray();
		}
		
		System.out.println(Arrays.deepToString(grades));
	}

}
