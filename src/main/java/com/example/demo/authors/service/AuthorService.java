package com.example.demo.authors.service;

import java.util.List;

import com.example.demo.authors.Author;

public interface AuthorService {
	List<Author> getAllAuthors();
	void addAuthor(Author author);
}
