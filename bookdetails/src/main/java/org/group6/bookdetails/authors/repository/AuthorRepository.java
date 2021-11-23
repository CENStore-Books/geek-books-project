package org.group6.bookdetails.authors.repository;

import org.group6.bookdetails.authors.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

	
}
