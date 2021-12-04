package net.codejava.product;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;

//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.codejava.shoppingcart.ShoppingCartWishlist;
import net.codejava.wishlist.Wishlist;

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
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Wishlist.class)
	@JoinColumn(name = "wishlist_id", referencedColumnName = "id")
	private Wishlist wishlist;
	//private Set<Wishlist> wishlist = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = ShoppingCartWishlist.class)
   	@JoinColumn(name = "shoppingcartwishlist_id", referencedColumnName = "id")
    private ShoppingCartWishlist shoppingcartwishlist;

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
	public ShoppingCartWishlist getShoppingCartWishlist() {
		return shoppingcartwishlist;
	}

	public void setShoppingCartWishlist(ShoppingCartWishlist shoppingcartwishlist) {
		this.shoppingcartwishlist = shoppingcartwishlist;
	}
	
	@Override
	public String toString() {
		return this.bookName;
	}

	
	
	
	/*
	public Set<Wishlist> getWishlist() {
		return wishlist;
	}

	public void setWishlist(Set<Wishlist> wishlist) {
		this.wishlist = wishlist;
	}*/
}
