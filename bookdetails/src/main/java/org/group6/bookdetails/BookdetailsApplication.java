package org.group6.bookdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookdetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookdetailsApplication.class, args);
	}

	// Manually inserting stuff to database
	/* @Override
	public void run(String... args) throws Exception {
		/* String sql = "INSERT INTO book_details (bookISBN, bookName, bookDesc, bookPrice, bookAuthor, bookGenre, bookPublisher, bookYearPublished, bookCopiesSold) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int result = jdbcTemplate.update(sql, "123456", "Sus book", "It's sus", 69.99, "Sus man", "Sus genre", "Sussysos", 2021, 420000);

		if (result > 0) {
			System.out.println("A new row has been inserted.");
		}

	}  */

}
