package com.example.demo.wishlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.product.Product;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
	
	public Wishlist findByProduct(Product product);

}
