package com.example.demo.wishlist;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.product.Product;

@Entity
@Table(name = "wishlist" )
public class Wishlist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
    
    @Column(unique = true, nullable = false, length = 45)
    private String name;
    
    @ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
    
    /*
       @ManyToOne
		@JoinColumn(name = "customer_id")
		private Customer customer;
     */
    
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


	

 
    
    
}