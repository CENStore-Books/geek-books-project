package com.example.demo.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

import com.example.demo.wishlist.Wishlist;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
     
	@Column(length = 128, nullable = false, unique = true)
	private String bookName;
	
	@Column(length = 128, nullable = false)
	private String bookAuthor;
	
    @Column(length = 128, nullable = false)
    private String bookGenre;
    
    @Column(length = 64, nullable = false)
    private int bookYearPublished;
	
	@Column(length = 2000, nullable = false, unique = true)
	private String bookDescription;
	
	private float bookPrice;
	
	@ManyToOne
	@JoinColumn(name = "wishlist_id")
	private Wishlist wishlist;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookGenre() {
		return bookGenre;
	}

	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}

	public int getBookYearPublished() {
		return bookYearPublished;
	}

	public void setBookYearPublished(int bookYearPublished) {
		this.bookYearPublished = bookYearPublished;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public float getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(float bookPrice) {
		this.bookPrice = bookPrice;
	}

	public Wishlist getWishlist() {
		return wishlist;
	}

	public void setWishlist(Wishlist wishlist) {
		this.wishlist = wishlist;
	}
	
	
}
