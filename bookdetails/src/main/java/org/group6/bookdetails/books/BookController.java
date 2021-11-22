package org.group6.bookdetails.books;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

	@Autowired
	private BookRepository repo;

	/* @GetMapping("/books")
	public List<bookdetailslist> booklist() {
		
		return repo.findAll();
	} */

	@GetMapping("/books")
	public String booklist(Model model) {
		model.addAttribute("book", repo.findAll());
		return "books";
	}
}
