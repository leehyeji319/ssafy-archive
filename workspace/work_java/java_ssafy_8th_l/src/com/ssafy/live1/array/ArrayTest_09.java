package com.ssafy.live1.array;

import java.util.Arrays;

public class ArrayTest_09 {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        int[] scores = {90, 80, 100};

        // TODO: 95점을 추가로 관리하기 부적절한 코드는?
        // scores[3] = 95;                             // #1 -> 인덱스3이 없는데 어케함

         scores = new int[] {90, 80, 100, 95};       // #2

        // scores = {90, 80,100, 95 };                 // #3 -> new int [] 잇어야함/

         scores = Arrays.copyOf(scores, 5);             // #4 -> scores를 복사해서 5개짜리 배열로 만들어라
         scores[3]=95;
        
         int[] scores2 = new int[4];                    // #5
         System.arraycopy(scores, 0, scores2, 0, scores.length);  //source에 대한걸 destination에 넣어라
         scores2[3] = 95;
        
    }
}
