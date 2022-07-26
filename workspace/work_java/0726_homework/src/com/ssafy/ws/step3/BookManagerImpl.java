package com.ssafy.ws.step3;

import java.util.Arrays;

public class BookManagerImpl implements IBookManager {
	
	private static final int MAX_SIZE = 100;
	private Book[] books = new Book[MAX_SIZE];
	private int size;
	
	//=====singleton=======//
	
	private static BookManagerImpl instance = new BookManagerImpl();
	
	private BookManagerImpl() {
		
	}
	
	public static BookManagerImpl getInstance() {
		return instance;
	}
	
	//====================//
	
	
	@Override
	public void add(Book book) {
		if (size < MAX_SIZE) books[size++] = book;
	}
	
	@Override
	public void remove(String isbn) {
		for (int i = 0; i < size; i++) {
			// 지우려고하는 책을 맨뒤에서 뽑아서 매꿔주기, size - 1
			if (books[i].getIsbn().equals(isbn)) {
				books[i] = books[size - 1];
				books[size - 1] = null; // 마지막 책 자리에 레퍼런스 살아있으니까 명시적으로 참조를 끊어준것
				--size;
				break;
			}
		}
	}
	
	@Override
	public Book[] getList() {
		return Arrays.copyOfRange(books, 0, size);
	}
	
	@Override
	public Book searchByIsbn(String isbn) {
		for (int i = 0; i < size; i++) {
			if (books[i].getIsbn().equals(isbn))
				return books[i];
		}
		return null; // 다돌아도 못찾는다면 null리턴
	}
	
	@Override
	public Book[] searchByTitle(String title) {
		
		int cnt = 0;
	    for (int i = 0; i < this.size; i++) {
	        if (books[i].getTitle() != null && books[i].getTitle().contains(title)) {
	            cnt++;
	        }
	    }
	    if (cnt == 0)
	        return null;

	    Book[] temp = new Book[cnt];
	    cnt = 0;
	    for (int i = 0; i < this.size; i++) {
	        if (books[i].getTitle() != null && books[i].getTitle().contains(title)) {
	            temp[cnt++] = books[i];
	        }
	    }
	    return temp;
	}
	
	@Override
	public Magazine[] getMagazines() {	
		int count = 0;
		for (int i = 0; i <size; i++) {
			if (books[i] instanceof Magazine) ++count;
		}
		Magazine [] result = new Magazine[count];
		int idx = 0;
		for (int i = 0; i <size; i++) {
			if (books[i] instanceof Magazine) {
				result[idx++] = (Magazine)books[i];
			}
		}
		return result;
	}

	@Override
	public Book[] getBooks() {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (!(books[i] instanceof Magazine)) ++count;
		}
		
		Book[] result = new Book[count];
		int idx = 0;
		for (int i = 0; i <size; i++) {
			if (!(books[i] instanceof Magazine)) {
				result[idx++] = books[i];
			}
		}
		return result;
	}
	
	@Override
	public int getTotalPrice() {
		int totalPrice = 0;
		for (int i = 0; i < size; i++) {
			totalPrice += books[i].getPrice();
		}
		return totalPrice;
	}
	
	@Override
	public double getPriceAvg() {
		int totalPrice = 0;
		for (int i = 0; i < size; i++) {
			totalPrice += books[i].getPrice();
		}
		return totalPrice/size;
	}
	
}
