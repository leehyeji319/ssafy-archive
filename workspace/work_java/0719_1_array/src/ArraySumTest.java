public class ArraySumTest {
	public static void main(String[] args) {

		// 참고하기
		System.out.println('2' - '0'); //이렇게 하면 숫자 2를 구한거다.

		char[][] map = { { '2', '3', '1', '4' }, { '1', 'x', '3', '2' }, { '3', '4', 'x', 'x' },
				{ 'x', '4', '1', '5' } };

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		int sum = 0;

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] != 'x')
					continue;

				for (int d = 0, dSize = dr.length; d < dSize; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];

					// 경계값체크
					if (nr >= 0 && nc >= 0 && nr < map.length && nc < map.length && map[nr][nc] != 'x') {
						sum += map[nr][nc] - '0';
						map[nr][nc] = '0'; //지나간 탐색을 마킹효과
					}
				}
			}
		}

		System.out.println(sum);
	}
}
