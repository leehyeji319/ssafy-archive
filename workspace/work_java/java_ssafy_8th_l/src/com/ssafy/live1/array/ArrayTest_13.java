package com.ssafy.live1.array;


public class ArrayTest_13 {
    public static void main(String[] args) {
        int[] intArray = {1, 3, 4, 7, 8, 10, 12, 15, 16, 17, 18};

        // TODO: 1~20까지의 숫자 중 intArray에서 사용되지 않은 숫자를 출력하세요.
        int [] countNum = new int[20];
        for (int num : intArray) {
			countNum[--num]++;  
		}
        
        for (int i = 0; i < countNum.length; i++) {
        	//System.out.println(countNum[i]);
        	if (countNum[i] != 0) continue;
        	System.out.print((i + 1) + " ");
        }
        // END:
    }
}
