package org.group6.bookdetails.books.controller;

import org.group6.bookdetails.books.Book;
import org.group6.bookdetails.books.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

	@Autowired
	private BooksService repo;

	@GetMapping("/books")
	public String booklist(Model model) {

		model.addAttribute("listBooks", repo.getAllBooks());
		return "books";
	}

	@GetMapping("/addNewBookForm")
	public String addNewBookForm(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "new_book";
	}

	@PostMapping("/addNewBook")
	public String addNewBook(@ModelAttribute("book") Book book) {
		repo.addBook(book);
		return "redirect:/books";
	}
}
