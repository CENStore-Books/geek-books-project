package org.group6.bookdetails.books;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.group6.bookdetails.authors.Author;

@Entity
@Table(name = "booksList")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id = 1;
	
	@Column(name = "bookISBN")
	private int bookISBN;

	@Column(name = "bookName")
	private String bookName;

	@Column(name = "bookDesc")
	private String bookDesc;

	@Column(name = "bookPrice")
	private double bookPrice;

	@Column(name = "bookGenre")
	private String bookGenre;

	@Column(name = "bookYearPublished")
	private int bookYearPublished;

	@Column(name = "bookCopiesSold")
	private int bookCopiesSold;

	@ManyToOne
	@JoinColumn(name = "bookAuthorID")
	private Author author;

	public Book(){}

	public Book(int id, int bookISBN, String bookName, String bookDesc, double bookPrice, int bookAuthorID, String bookAuthor, String bookGenre, String bookPublisher, int bookYearPublished, int bookCopiesSold, Author author) {
		this.id = id;
		this.bookISBN = bookISBN;
		this.bookName = bookName;
		this.bookDesc = bookDesc;
		this.bookPrice = bookPrice;
		this.bookGenre = bookGenre;
		this.bookYearPublished = bookYearPublished;
		this.bookCopiesSold = bookCopiesSold;
		this.author = author;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBookISBN() {
		return this.bookISBN;
	}

	public void setBookISBN(int bookISBN) {
		this.bookISBN = bookISBN;
	}

	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookDesc() {
		return this.bookDesc;
	}

	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}

	public double getBookPrice() {
		return this.bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookGenre() {
		return this.bookGenre;
	}

	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}
	
	public int getBookYearPublished() {
		return this.bookYearPublished;
	}

	public void setBookYearPublished(int bookYearPublished) {
		this.bookYearPublished = bookYearPublished;
	}

	public int getBookCopiesSold() {
		return this.bookCopiesSold;
	}

	public void setBookCopiesSold(int bookCopiesSold) {
		this.bookCopiesSold = bookCopiesSold;
	}

	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

}
