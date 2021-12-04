package net.codejava.product;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductsRepository extends JpaRepository<Product, Integer> {

	
	//@Query("SELECT p FROM Product p WHERE p.wishlist.id = ?1")
	//public List<Product> findByWishlistId(@Param("wishlist_id")Integer wishlist_id);

	@Query("SELECT p FROM Product p WHERE p.wishlist.id = ?1")
	public List<Product> findAllByID(@Param("wishlist_id")Integer wishlist_id);
	
	
	//not working find sc 
	//@Query("SELECT c FROM Product c WHERE c.shoppingcartwishlist.id = ?1")
	//public List<Product> findAllBySCID(@Param("shoppingcartwishlist_id")Integer shoppingcartwishlist_id);
	
	/*New
	@Query("Insert c FROM Product p WHERE p..id = ?1")
	public Product addToShoppingCart(Integer id);
	*/
	
}
