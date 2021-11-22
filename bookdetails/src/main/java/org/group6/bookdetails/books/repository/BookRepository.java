package org.group6.bookdetails.books.repository;

import org.group6.bookdetails.books.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	/* List<BookDetailsSetup> findAll(); */

}
