package com.ssafy.ws.step3;

public class BookTest {

	public static void main(String[] args) {
		
//		IBookManager bm = BookManagerImpl.getInstance();
		IBookManager bm = BookManagerImplList.getInstance();
//		IBookManager bm = BookManagerImplMap.getInstance();
		
		bm.add(new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법", 10));
		bm.add(new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용", 20));
		bm.add(new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링", 30));
		bm.add(new Magazine("45678", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 40, 2021, 1));
		
		System.out.println("도서 전체 목록");
		Book[] bookList = bm.getList();
		
		for (int i = 0; i < bm.getList().length; i++) {
			System.out.println(bookList[i]);
		}
		
		System.out.println("일반 도서 목록");
		
		Book[] onlyBookList = bm.getBooks();
		
		for (int i = 0; i < onlyBookList.length; i++) {
			System.out.println(onlyBookList[i]);
		}
		
		System.out.println("잡지 목록");
		
		Magazine[] magazineList = bm.getMagazines();
		
		for (int i = 0; i < magazineList.length; i++) {
			System.out.println(magazineList[i]);
		}
		
		System.out.println("도서 제목 포함검색:Java");
		
		Book[] bookTitleList = bm.searchByTitle("Java");
		
		for (int i = 0; i < bookTitleList.length; i++) {
			System.out.println(bookTitleList[i]);
		}
		
		System.out.println("도서 가격 총합 : " + bm.getTotalPrice());
		
		System.out.println("도서 가격 평균 : " + bm.getPriceAvg());
		
		System.out.println("*********도서판매: 21424, 11개*************");
		try {
			bm.sell("21424", 11);
		} catch (QuantityException e) {
			// TODO Auto-generated catch block
			System.out.println("수량이 부족합니다.");
		}
		System.out.println("********도서구매: 21424, 10개**************");
		bm.buy("21424", 10);
		System.out.println("*********도서판매: 21424, 11개*************");
		try {
			bm.sell("21424", 11);
		} catch (QuantityException e) {
			// TODO Auto-generated catch block
			System.out.println("수량이 부족합니다.");
		}
	}

}
