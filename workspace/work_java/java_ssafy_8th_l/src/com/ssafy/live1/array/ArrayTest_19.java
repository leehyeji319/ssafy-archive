package com.ssafy.live1.array;

public class ArrayTest_19 {

    public static void main(String[] args) {


        char[][] grid = {{'2', '3', '1', '4'}, 
                         {'1', 'X', '3', '2'}, 
                         {'3', '4', 'X', 'X'}, 
                         {'X', '4', '1', '5'}};

        int sum = 0;
        // TODO: X로 표시된 항목의 상하좌우 숫자의 합을 구하시오.
        // 이미 더한 숫자는 포함시키지 않는다.
        
        int [] dx = {-1, 1, 0, 0};
        int [] dy = {0, 0, -1, 1};
        
        for (int i = 0; i < grid.length; i++) {
        	for(int j = 0; j < grid[i].length; j++) {
        		
        		if (grid[i][j] != 'X') continue;
        		
        		for (int d = 0, dSize = dx.length; d < dSize; d++) {
        			int nx = i + dx[d];
        			int ny = j + dy[d];
        			
        			//경계값 체크
        			if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid.length || grid[nx][ny] == 'X') continue;
        			
        			sum += grid[nx][ny] - '0';
        			
        			grid[nx][ny] = '0';
        		}
        	}
        }
        
        // END:
        System.out.println(sum);
    }
}
