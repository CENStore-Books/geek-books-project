package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, String>{
	
	public List<Book> findByGenre(String genre);
	
	
	public List<Book> findByRating(double rating);

}
