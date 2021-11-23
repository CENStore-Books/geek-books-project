package org.group6.bookdetails.books.service;

import java.util.List;

import org.group6.bookdetails.books.Book;

public interface BooksService {
	List<Book> getAllBooks();
	void addBook(Book book);
	List<Book> findByAuthorID(String id);
}
