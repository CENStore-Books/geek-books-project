package org.group6.bookdetails.books.repository;

import java.util.List;

import org.group6.bookdetails.books.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
	@Query("SELECT b FROM Book b WHERE b.author.id =:id")
	public List<Book> findAllByID(@Param("id") int id);
}
