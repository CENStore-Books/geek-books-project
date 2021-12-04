package net.codejava.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


@Service
public class ProductServiceImplement implements ProductService{

	
	@Autowired
	private ProductsRepository productRepo;
	
	//@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	//@Override
	//public void addProduct(Product product) {
	//	this.productRepo.save(product);	
	//}		

	@Override
	public List<Product> findByWishlistId(@PathVariable(value="wishlist_id") Integer wishlist_id) {
		return productRepo.findAllByID(wishlist_id);
	}	
	
	// not working find sc
	// @Override
	//public List<Product> findByShoppingCartWishlistId(@PathVariable(value="shoppingcartwishlist_id") Integer shoppingcartwishlist_id) {
	//	return productRepo.findAllBySCID(shoppingcartwishlist_id);
	// }
	 
}
