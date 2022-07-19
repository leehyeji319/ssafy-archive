import java.util.Arrays;
import java.util.Scanner;

//배열 : 고정크기의 동형집합(homogeneous collection)
//		객체, 참조형타입
//데이터타입[] 참조변수 = new 데이터타입[크기]; => 배열의 원소값들은 데이터타입의 기본값으로 자동초기화된다.
//참조변수[인덱스] ==> 인덱스의 유효범위: 0~크기-1
//					ArrayIndexOutofBoundsException
// 배열 사용이유? 
// 1.일괄처리
// 2.원소들을 모아 하나의 단위로 처리(매개변수로 전달하거나 리턴)
// 
public class ArrayTest {

	public static void main(String[] args) {

		int[] arr2 = { 100, 90, 80 }; 
		arr2 = new int[] {34,35}; //이렇게 되면 위에는 가비지컬렉션에 들어간다.
		
		int[] arr3 = new int[] { 1, 2, 3 };

		Scanner sc = new Scanner(System.in); // 성능은 ㅂㄹ
		// 데이터의 흐름 : stream

		int N = sc.nextInt(); // 과목수
		int[] scores = new int[N]; // 힙에적재 //과목의 성적

		for (int i = 0; i < N; i++) {
			scores[i] = sc.nextInt(); // white 문자 기준
		}

		print(scores);
		System.out.println(Arrays.toString(getGrade(scores)));

	}

	static void print(int[] arr) {
		// size배열의 길이 변하지 않으니까, 매개변수나 변수타입 맞춰조라ㅋㅋ
		for (int i = 0, size = arr.length; i < size; i++) {
			System.out.println(arr[i]);
		}
	}
//	static void print(int[] arr) {
//		for (int a : arr) {
//			System.out.println(a);
//		}
//	}

	// 점수배열 받아서 학점배열 리턴
	// 90이상이면 a, 80이상b, 70이상c, 60미만ㅇ이면F
	public static char[] getGrade(int[] scores) {
		int size = scores.length;
		char[] grades = new char[size];

		for (int i = 0; i < size; i++) {
			char grade = 'F';
			if (i >= 90)
				grade = 'A';
			else if (i >= 80)
				grade = 'B';
			else if (i >= 70)
				grade = 'C';

			grades[i] = grade;
		}

		return grades;
	}

}
