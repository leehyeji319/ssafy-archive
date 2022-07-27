package com.ssafy.ws.step3;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BookManagerImplList implements IBookManager {

	private static final int MAX_SIZE = 100;
//	private Book[] books = new Book[MAX_SIZE];

	private ArrayList<Book> books = new ArrayList<>();
	
	// =====singleton=======//
	/**
	 * 싱글톤 디자인패턴 위에 유지하는 객체 참조값 클래스 메모리에 로드시에 객체 1번 생성하여 참조값 유지
	 */
	private static IBookManager instance = new BookManagerImplList();

	// 기본 생성자
	private BookManagerImplList() {

	}

	public static IBookManager getInstance() {
		return instance;
	}

	// ====================//

	@Override
	public void add(Book book) {
		if (books.size() < MAX_SIZE)
			books.add(book);
	}

	@Override
	public void remove(String isbn) {
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getIsbn().equals(isbn)) {
				books.remove(i);
//				books.remove(searchByIsbn(isbn));
			} else {
				System.out.println("찾으시는 책이 없습니다.");
			}
		}
	}

	@Override
	public Book[] getList() {
		Book[] result = new Book[books.size()];
//		Book[] bs = books.toArray(b);
		return books.toArray(result);
	}


	@Override
	public Book searchByIsbn(String isbn) {
		//이런 코드는 지양하면 좋겠다. 변수를 쓰는게 좋다고 !
		// books.get(i)를 여러번하면 얼마나 오버헤드가 발생하겠어
//		for (int i = 0; i < books.size(); i++) {
//			if (books.get(i).getIsbn().equals(isbn)) {
//				return books.get(i); 
//			}
//		}
		
		for (int i = 0; i < books.size(); i++) {
			Book book = books.get(i);
			if (book.getIsbn().equals(isbn)) {
				return book;
			}
		}
		return null;
	}

	
	@Override
	public Book[] searchByTitle(String title) {
		ArrayList<Book> list = new ArrayList<>();
		for (int i =0; i < books.size(); i++) {
			if (books.get(i).getTitle().equals(title)) {
				list.add(books.get(i));
			}
		}
		return list.toArray(new Book[list.size()]);
	}
	
	@Override
	public Magazine[] getMagazines() {
		
		ArrayList<Magazine> list = new ArrayList<>();
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i) instanceof Magazine) {
				list.add((Magazine) books.get(i));
			}
		}
		
		return list.toArray(new Magazine[list.size()]);
	}

	@Override
	public Book[] getBooks() {
		int count = 0;
		for (int i = 0; i < books.size(); i++) {
			if (!(books.get(i) instanceof Magazine))
				++count;
		}

		Book[] result = new Book[count];
		int idx = 0;
		for (int i = 0; i < books.size(); i++) {
			if (!(books.get(i) instanceof Magazine)) {
				result[idx++] = books.get(i);
			}
		}
		return result;
	}

	@Override
	public int getTotalPrice() {
		int totalPrice = 0;
		for (int i = 0; i < books.size(); i++) {
			totalPrice += books.get(i).getPrice();
		}
		return totalPrice;
	}

	@Override
	public double getPriceAvg() {
		int totalPrice = 0;
		for (int i = 0; i < books.size(); i++) {
			totalPrice += books.get(i).getPrice();
		}
		return totalPrice / books.size();
	}

}
