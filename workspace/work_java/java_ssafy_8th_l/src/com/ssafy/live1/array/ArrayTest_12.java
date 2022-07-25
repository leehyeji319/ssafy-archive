package com.ssafy.live1.array;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayTest_12 {
    public static void main(String[] args) {
    	
        int[] intArray = {3, 7, 2, 5, 7, 7, 9, 2, 8, 1, 1, 5, 3};

        // TODO: 각 숫자가 몇 번 사용 되었는지 숫자별로 사용 횟수를 출력 하세요.
        //  사용 안된 숫자는 0으로 출력 한다. 범위 1-10
        int [] countNum = new int[11];
        for (int num : intArray) {
			countNum[--num]++;
		}
        
        for (int i = 1; i < countNum.length - 1; i++) {
        	System.out.println(i + ":" + countNum[i]);
        }
        
        // END:
    }
}
