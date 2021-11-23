package org.group6.bookdetails.authors.service;

import java.util.List;

import org.group6.bookdetails.authors.Author;
import org.group6.bookdetails.authors.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepo; 

	@Override
	public List<Author> getAllAuthors() {
		return authorRepo.findAll();
	}

	@Override
	public void addAuthor(Author author) {
		this.authorRepo.save(author);
	}
}
