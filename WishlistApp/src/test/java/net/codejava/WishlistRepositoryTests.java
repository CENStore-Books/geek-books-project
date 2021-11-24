package net.codejava;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import net.codejava.wishlist.Wishlist;
import net.codejava.wishlist.WishlistRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class WishlistRepositoryTests {

	@Autowired 
	private WishlistRepository repo;
	
	@Test
	public void testSaveItem() {
		Wishlist savedWishlist = repo.save(new Wishlist());
		
		assertThat(savedWishlist.getId()).isGreaterThan(0);
		
	}
	

	
}