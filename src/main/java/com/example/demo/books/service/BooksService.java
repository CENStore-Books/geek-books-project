package com.example.demo.books.service;

import java.util.List;

import com.example.demo.books.Books;

public interface BooksService {
	List<Books> getAllBooks(String isbn);
	void addBook(Books book);
	List<Books> findByAuthorID(int aID);
}
