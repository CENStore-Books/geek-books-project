package org.group6.bookdetails.authors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
	@RequestMapping(value = "/authors")
	public String welcome() {
		return "authors";
	}
}
