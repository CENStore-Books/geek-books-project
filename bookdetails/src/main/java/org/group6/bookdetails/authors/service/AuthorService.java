package org.group6.bookdetails.authors.service;

import java.util.List;

import org.group6.bookdetails.authors.Author;

public interface AuthorService {
	List<Author> getAllAuthors();
	void addAuthor(Author author);
}
