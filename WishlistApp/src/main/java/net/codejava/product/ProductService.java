package net.codejava.product;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import net.codejava.product.Product;

@Service
@Transactional
public interface ProductService {
	
	List<Product> findByWishlistId(Integer wishlist_id);
	
	//not working find sc 
	//List<Product> findByShoppingCartWishlistId(Integer shoppingcartwishlist_id);
}

