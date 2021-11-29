package org.group6.bookdetails.books.controller;

import java.util.List;

import org.group6.bookdetails.authors.Author;
import org.group6.bookdetails.authors.service.AuthorService;
import org.group6.bookdetails.books.Book;
import org.group6.bookdetails.books.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

	@Autowired
	private BooksService bookRepo;
	
	@Autowired
	private AuthorService authorRepo;

	@GetMapping("/books")
	public String booklist(Model model, @Param("isbn") String isbn) {

		model.addAttribute("listBooks", bookRepo.getAllBooks(isbn));
		model.addAttribute("listFilteredBooks", isbn);
		return "books";
	}

	@GetMapping("/addNewBookForm")
	public String addNewBookForm(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);

		List<Author> listAuthors = authorRepo.getAllAuthors();
		model.addAttribute("listAuthors", listAuthors);
		return "new_book";
	}

	@PostMapping("/addNewBook")
	public String addNewBook(@ModelAttribute("book") Book book) {
		bookRepo.addBook(book);
		return "redirect:/books";
	}

	@GetMapping("/showBooksByAuthor/{id}")
	public String showBooksByID(Model model, @PathVariable int id) {
		model.addAttribute("listFilteredBooks", bookRepo.findByAuthorID(id));
		return "show_books_by_author";
	}
}
