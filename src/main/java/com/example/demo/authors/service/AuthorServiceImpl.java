package com.example.demo.authors.service;

import java.util.List;

import com.example.demo.authors.Author;
import com.example.demo.authors.repository.AuthorRepository;
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
