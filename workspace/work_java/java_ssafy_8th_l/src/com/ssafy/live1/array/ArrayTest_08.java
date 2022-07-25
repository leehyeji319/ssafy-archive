package com.ssafy.live1.array;


public class ArrayTest_08 {
    public static void main(String[] args) {
        String[] students = {"홍길동", "임꺽정", "장길산", "이몽룡"};
        // TODO: 배열에서 임꺽정과 장길산의 위치를 변경해서 출력하시오.
        String temp = students[1];
        students[1] = students[2];
        students[2] = temp;
        
        for (String string : students) {
			System.out.println(string);
		}
        
        // END:
    }
}

//개별요소는 다른 값으로 변경이 가능하나, 요소를 추가하거나 삭제할 순 없다. immutable