package com.ssafy.ws.step3;

public class BookTest {

	public static void main(String[] args) {
		
		Book[] books = new Book[2];
		
		
		Book b1 = new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법");
		
		Book b2 = new Book("35355", "분석 설계", "소나무", "jaen.kr", 30000, "sw 모델링");
		
		books[0] = b1;
		books[1] = b2;
		
		
		
		System.out.println("****************도서목록****************");
		System.out.println(books[0]);
		System.out.println(books[1]);
	}

}
