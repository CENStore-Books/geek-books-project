package net.codejava.wishlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.codejava.product.Product;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
	
	public Wishlist findByProduct(Product product);

}
