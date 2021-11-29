package org.group6.bookdetails.books.service;

import java.util.List;

import org.group6.bookdetails.books.Book;
import org.group6.bookdetails.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class BooksServiceImpl implements BooksService {

	@Autowired
	private BookRepository bookRepo;
	
	@Override
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}

	@Override
	public void addBook(Book book) {
		this.bookRepo.save(book);
	}

	@Override
	public List<Book> findByAuthorID(@PathVariable(value="id") int id) {
		return bookRepo.findAllByID(id);
	}
	
}
