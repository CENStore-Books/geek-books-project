package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Book {
	
	@Id
	private int id;
	private String title;
	private String author;
	private String genre;
	private double rating;
	private int sales;
	
	
	public Book(int id, String title, String author, String genre, double rating, int sales) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.rating = rating;
		this.sales = sales;
		
	}
	
	public Book() {
	    //nothing goes here
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public double getRating() {
		return rating;
	}


	public void setRating(double rating) {
		this.rating = rating;
	}


	public int getSales() {
		return sales;
	}


	public void setSales(int sales) {
		this.sales = sales;
	}
	
	
	

	
	
}


