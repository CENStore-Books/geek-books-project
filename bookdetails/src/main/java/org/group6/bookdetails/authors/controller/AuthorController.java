package org.group6.bookdetails.authors.controller;

import org.group6.bookdetails.authors.Author;
import org.group6.bookdetails.authors.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {
	
	@Autowired
	private AuthorService authorRepo;

	@GetMapping("/authors")
	public String welcome(Model model) {
		model.addAttribute("listAuthors", authorRepo.getAllAuthors());
		return "authors";
	}

	@GetMapping("/addNewAuthorForm")
	public String addNewAuthorForm(Model model) {
		Author author = new Author();
		model.addAttribute("author", author);
		return "new_author";
	}

	@PostMapping("/addNewAuthor")
	public String addNewBook(@ModelAttribute("author") Author author) {
		authorRepo.addAuthor(author);
		return "redirect:/authors";
	}
}
