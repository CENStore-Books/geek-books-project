package com.example.demo.authors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.books.Books;

@Entity
@Table(name = "authorsList")
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "authorFirstName")
	private String authorFirstName;

	@Column(name = "authorLastName")
	private String authorLastName;

	@Column(name = "authorBio")
	private String authorBio;

	@Column(name = "authorPublisher")
	private String authorPublisher;

	@ManyToOne
	@JoinColumn(name = "bookID")
	private Books book;

	public Author() {
	}

	public Author(int id, String authorFirstName, String authorLastName, String authorBio, String authorPublisher, Books book) {
		this.id = id;
		this.authorFirstName = authorFirstName;
		this.authorLastName = authorLastName;
		this.authorBio = authorBio;
		this.authorPublisher = authorPublisher;
		this.book = book;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthorFirstName() {
		return this.authorFirstName;
	}

	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}

	public String getAuthorLastName() {
		return this.authorLastName;
	}

	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}

	public String getAuthorBio() {
		return this.authorBio;
	}

	public void setAuthorBio(String authorBio) {
		this.authorBio = authorBio;
	}

	public String getAuthorPublisher() {
		return this.authorPublisher;
	}

	public void setAuthorPublisher(String authorPublisher) {
		this.authorPublisher = authorPublisher;
	}

	public Books getBook() {
		return this.book;
	}

	public void setBook(Books book) {
		this.book = book;
	}
}
