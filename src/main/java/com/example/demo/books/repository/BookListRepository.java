package com.example.demo.books.repository;

import java.util.List;

import com.example.demo.books.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookListRepository extends JpaRepository<Books, String> {
	@Query("SELECT b FROM Books b WHERE b.author.id =:id")
	public List<Books> findAllByID(@Param("id") int id);

	@Query("SELECT b FROM Books b WHERE b.bookISBN =:isbn")
	public List<Books> findAllByISBN(@Param("isbn") String isbn);
}
