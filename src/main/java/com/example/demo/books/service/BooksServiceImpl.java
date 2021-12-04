package com.example.demo.books.service;

import java.util.List;

import com.example.demo.books.Books;
import com.example.demo.books.repository.BookListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class BooksServiceImpl implements BooksService {

	@Autowired
	private BookListRepository bookRepo;
	
	@Override
	public List<Books> getAllBooks(String isbn) {
		if (isbn != null){
			return bookRepo.findAllByISBN(isbn);
		}
		return bookRepo.findAll();
	}

	@Override
	public void addBook(Books book) {
		this.bookRepo.save(book);
	}

	@Override
	public List<Books> findByAuthorID(@PathVariable(value="id") int id) {
		return bookRepo.findAllByID(id);
	}	
}
