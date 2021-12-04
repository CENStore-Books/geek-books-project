package net.codejava.shoppingcart;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.codejava.product.Product;


@Entity
@Table(name = "shoppingcartwishlist")
public class ShoppingCartWishlist {

	@Id
	private Integer id;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;
	//
	
	
	public ShoppingCartWishlist() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


		
}
	
	
