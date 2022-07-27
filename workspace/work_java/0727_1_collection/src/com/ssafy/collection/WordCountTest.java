package com.ssafy.collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class WordCountTest {

	public static void main(String[] args) throws IOException {
		//키보드로 문젱을 입력받고 단어의 빈도수를 구하라.
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] words = in.readLine().split(" ");
		
//		HashMap<String, Integer> wordMap = new HashMap<>();
		TreeMap<String, Integer> wordMap = new TreeMap<>();
		
		for (String word : words) {
			if (wordMap.containsKey(word)) {
				wordMap.put(word, wordMap.get(word) + 1);
			} else {
				wordMap.put(word, 1);
			}
		}
		
		for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
			
		}
	}

}
