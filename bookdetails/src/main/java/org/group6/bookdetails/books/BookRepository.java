package org.group6.bookdetails.books;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<bookdetailslist, Integer> {
	bookdetailslist findById(int id);
	List<bookdetailslist> findAll();
	void deleteById(int id);
}
