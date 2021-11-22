package org.group6.bookdetails.books.service;

import java.util.List;

import org.group6.bookdetails.books.Book;
import org.group6.bookdetails.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksServiceImpl implements BooksService {

	@Autowired
	private BookRepository repo;
	
	@Override
	public List<Book> getAllBooks() {
		return repo.findAll();
	}

	@Override
	public void addBook(Book book) {
		this.repo.save(book);
	}
	
}
