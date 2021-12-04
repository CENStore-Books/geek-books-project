package net.codejava;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import net.codejava.product.Product;
import net.codejava.product.ProductsRepository;
import net.codejava.wishlist.Wishlist;
import net.codejava.wishlist.WishlistRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class WishlistRepositoryTests {

	@Autowired 
	private WishlistRepository wishlistRepo;
	
	@Autowired
	public ProductsRepository productRepo;
	
/*
	@Test
	public void testSaveItem() {
		
		Wishlist wishlist = wishlistRepo.findById(5).get();
		
		Product wishlistitem = productRepo.findByID(3);
		wishlist.addProduct(wishlistitem);
		
		Wishlist savedWishlist = wishlistRepo.save(wishlist);
		
		assertThat(savedWishlist.getProduct());
		
		*/
		
		//Wishlist listWishlist = wishlistRepo.save(new Wishlist());
		//assertThat(listWishlist.getId()).isGreaterThan(0);
		
		
		
	}
	

	
