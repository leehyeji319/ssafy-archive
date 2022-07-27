package com.ssafy.ws.step3;

import java.util.*;
import java.util.Map.Entry;

public class BookManagerImplMap implements IBookManager {
	
//	private Book[] books = new Book[MAX_SIZE];
	private HashMap<String, Book> books = new HashMap<>();
	
	//=====singleton=======//
	/**
	 * 싱글톤 디자인패턴 위에 유지하는 객체 참조값
	 * 클래스 메모리에 로드시에 객체 1번 생성하여 참조값 유지
	 */
	private static IBookManager instance = new BookManagerImplMap();
	
	//기본 생성자
	private BookManagerImplMap() {
		
	}
	
	public static IBookManager getInstance() {
		return instance;
	}
	
	//====================//
	
	
	@Override
	public void add(Book book) {
		books.put(book.getIsbn(), book); //bookmap에는 레퍼런스가 저장! 객체는 가만히잇지ㅋㅋ
	}
	
	@Override
	public void remove(String isbn) {
		if (books.containsKey(isbn)) books.remove(isbn);
	}
	
	@Override
	public Book[] getList() {
		//return books.values().toArray(new Book[books.size])
		return books.values().toArray(new Book[0]); //size가 0이면 못담으니까 얘네는 어쨋든 새로 만듬!
	}
	
	@Override
	public Book searchByIsbn(String isbn) {
		
		return books.get(isbn);
	}

	@Override
	public Book[] searchByTitle(String title) {
		
		List<Book> result = new ArrayList<>();
		
		for (Book book : books.values()) {
			if (book.getTitle().contains(title)) result.add(book);
		}
		
		return result.toArray(new Book[0]);
		
	}
	
	@Override
	public Magazine[] getMagazines() {	
		List<Book> result = new ArrayList<>();
		
		for (Book book : books.values()) {
			if (book instanceof Magazine) 
				result.add(book);
		}
		
		return result.toArray(new Magazine[0]);
		
	}

	@Override
	public Book[] getBooks() {
		List<Book> result = new ArrayList<>();
		
		for (Book book : books.values()) {
			if (book instanceof Magazine) 
				continue;
			result.add(book);
		}
		
		return result.toArray(new Book[0]);
	}
	
	@Override
	public int getTotalPrice() {
		int totalPrice = 0;
		
		for (Book book : books.values()) {
			totalPrice += book.getPrice();
		}
		
		return totalPrice;
	}
	
	@Override
	public double getPriceAvg() {
		
		return (double) getTotalPrice() / books.size();
	}
	
}
