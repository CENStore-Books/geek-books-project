package org.group6.bookdetails.books;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class bookdetailslist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id = 1;
	
	private int bookISBN;
	private String bookName;
	private String bookDesc;
	private double bookPrice;
	private int bookAuthorID;
	private String bookAuthor;
	private String bookGenre;
	private String bookPublisher;
	private int bookYearPublished;
	private int bookCopiesSold;

	public bookdetailslist(){}
	
	public bookdetailslist(int id, int bookISBN, String bookName, String bookDesc, double bookPrice, int bookAuthorID, String bookAuthor, String bookGenre, String bookPublisher, int bookYearPublished, int bookCopiesSold) {
		this.id = id;
		this.bookISBN = bookISBN;
		this.bookName = bookName;
		this.bookDesc = bookDesc;
		this.bookPrice = bookPrice;
		this.bookAuthorID = bookAuthorID;
		this.bookAuthor = bookAuthor;
		this.bookGenre = bookGenre;
		this.bookPublisher = bookPublisher;
		this.bookYearPublished = bookYearPublished;
		this.bookCopiesSold = bookCopiesSold;
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

	public int getBookAuthorID() {
		return this.bookAuthorID;
	}

	public void setBookAuthorID(int bookAuthorID) {
		this.bookAuthorID = bookAuthorID;
	}

	public String getBookAuthor() {
		return this.bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookGenre() {
		return this.bookGenre;
	}

	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}

	public String getBookPublisher() {
		return this.bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
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
}
