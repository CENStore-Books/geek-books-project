package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	 	@Autowired
	    private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public BookRepository bookRepository;
	
	public List<Book> getAllBooks() throws Exception {
		
	    List<Book> books = new ArrayList<>();
		
	
	    jdbcTemplate.query(
	            "SELECT * FROM new_table", new Object[] {  },
	            (rs, rowNum) -> new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getString("genre") , rs.getDouble("rating") , rs.getInt("sales"))
	        ).forEach(book -> books.add(book));
	   
	      
		
	    return books;		
	}
	
	
	
	public void addBook(Book book) {
	     bookRepository.save(book);
	}

	
	public Optional<Book> getBook(String id) {
	     return bookRepository.findById(id);
	}
	
	public void updateBook(String id, Book book) {
	     bookRepository.save(book);
	}
	
	public void deleteBook(String id) {
	     bookRepository.deleteById(id);
	}


	

	public List<Book> getBookByGenre(String genre) {
		
		  List<Book> books = new ArrayList<>();
		 jdbcTemplate.query(
		            "SELECT * FROM new_table WHERE genre = ?", new Object[] { genre },
		            (rs, rowNum) -> new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getString("genre") , rs.getDouble("rating") , rs.getInt("sales"))
		        ).forEach(book -> books.add(book));
		      
		return books;
		
		
	}


	public List<Book> getBookByRating(double rating) {
		
		 List<Book> books = new ArrayList<>();
		 jdbcTemplate.query(
		            "SELECT * FROM new_table WHERE rating = ?", new Object[] { rating },
		            (rs, rowNum) -> new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getString("genre") , rs.getDouble("rating") , rs.getInt("sales"))
		        ).forEach(book -> books.add(book));
		      
		return books;
		
		
	}
	
	
	public List<Book> sortByTop() {
		
		  List<Book> books = new ArrayList<>();
		 jdbcTemplate.query(
		            "SELECT * FROM new_table ORDER BY sales DESC LIMIT 10", new Object[] {  },
		            (rs, rowNum) -> new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getString("genre") , rs.getDouble("rating") , rs.getInt("sales"))
		        ).forEach(book -> books.add(book));
		      
		return books;
		
		
	}
	
	public List<Book> Booksbyint(int x) {
		
		 List<Book> books = new ArrayList<>();
			
			
		    jdbcTemplate.query(
		            "SELECT * FROM new_table ORDER BY id LIMIT ?, 10", new Object[] { x*10 },
		            (rs, rowNum) -> new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getString("genre") , rs.getDouble("rating") , rs.getInt("sales"))
		        ).forEach(book -> books.add(book));
		   
		      
			
		    return books;		
		}
	
		
		
	}

