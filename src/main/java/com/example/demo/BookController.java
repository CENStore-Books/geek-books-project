package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	
	
	@Autowired
	private BookService bookService;

	 @RequestMapping(value = "/books")
	   public List<Book> getAllBooks() 
	   {		
		try {
			return bookService.getAllBooks();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	   }	
	 
	 
	 @RequestMapping(value = "/books/{id}")
	 public Optional<Book> getBooks(@PathVariable String id) {
	 	return bookService.getBook(id);
	 }
	 
	 
	 @RequestMapping(value = "/books", method=RequestMethod.POST)
	 public void addBook(@RequestBody Book book) {
		 bookService.addBook(book);
	 }
	 
	 @RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
	 public void updateBook(@RequestBody Book book,@PathVariable String id ) {
		 bookService.updateBook(id, book);
	 }
	 
	 @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
	 public void deleteBook(@PathVariable String id) {
		 bookService.deleteBook(id);
		 	 
	 }
	 @RequestMapping(value = "/books/genre/{genre}")
	 public List<Book> getBookByGenre(@PathVariable String genre){
		 return bookService.getBookByGenre(genre);
	 }
	 
	 @RequestMapping(value = "/books/rating/{rating}")
	 public List<Book> getBookByRating(@PathVariable double rating){
		 return bookService.getBookByRating(rating);
	 }
	 
	 @RequestMapping(value = "/books/top")
	 public List<Book> sortByTop(){
		 return bookService.sortByTop();
	 }
	 
	 @RequestMapping(value = "/books/page/{x}")
	 public List<Book> getBooksbyint(@PathVariable int x){
		 return bookService.Booksbyint(x);
	 }
	
	 
	 
}

