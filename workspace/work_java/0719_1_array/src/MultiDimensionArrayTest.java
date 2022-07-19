//다차원배열
//array of array
//데이터타입[][] 참조변수명 = new 데이터타입[주배열크기][부분배열크기];
//주배열의 크기는 필수, 부분배열의 크기는 옵션 (생략가능)
//int[] 참조변수 [] or int[][] 참조변수
//int[] 참조변수[] = new int[3][2];

public class MultiDimensionArrayTest {

	public static void main(String[] args) {

//		int[][] scores = new int[3][3];
//
//		scores[0][0] = 100;
//		scores[0][1] = 100;
//		scores[1][0] = 100;
//		scores[1][1] = 100;
//		scores[2][0] = 100;
//		scores[2][1] = 100;

		// 내가 생성하던지
		// 기존에 있던 다른 배열을 받던지. 이렇게 두가지가 있다.

		int[] score = { 100, 99, 87 };

//		int[][] scores = new int[3][];
//
//		scores[0] = new int[] { 100, 99 };
//		scores[1] = score;
//		scores[2] = new int[] { 80, 79, 99, 100 };
//		//앗! 부분배열의 크기가 다 다르다!

		int[][] scores = { { 80, 79, 99, 100 }, score, { 100, 99 } };

		print(scores);

	}

	static void print(int[][] arr) {

		for (int i = 0, sSize = arr.length; i < sSize; i++) {
			for (int j = 0, cCize = arr[0].length; j < cCize; j++) {
				System.out.println(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
