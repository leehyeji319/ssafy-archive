package com.ssafy.ws.step3;

public interface IBookManager {
	
	

	void add(Book book);

	void remove(String isbn);

	Book[] getList();

	Book searchByIsbn(String isbn) throws ISBNNotFoundException;

	Book[] searchByTitle(String title);

	Magazine[] getMagazines();

	Book[] getBooks();

	int getTotalPrice();

	double getPriceAvg();
	
	void sell(String isbn, int quantity) throws QuantityException;
	
	void buy(String isbn, int quantity);

	
}