package net.codejava.wishlist;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.codejava.product.Product;
import net.codejava.product.ProductsRepository;
//import net.codejava.shoppingcart.ShoppingCart;
//import net.codejava.shoppingcart.ShoppingCartRepository;
import net.codejava.shoppingcart.ShoppingCartWishlist;
import net.codejava.shoppingcart.ShoppingCartRepository;


@Controller
public class WishlistController {

	@Autowired
	private WishlistRepository wishlistRepo;
	
	@Autowired
	public ProductsRepository productRepo;
	
	@Autowired
	private ShoppingCartRepository scRepo;

	
	@GetMapping("/wishlist")
	public String listWishlist(Model model) {
		List<Wishlist> listWishlist = wishlistRepo.findAll();
		model.addAttribute("listWishlist",listWishlist);
		
		return "wishlist";
	}
		
	@GetMapping("/wishlist/new")
	public String showWishlistNewFormModel(Model model) {
		
		model.addAttribute("wishlist", new Wishlist());
			
		return "wishlist_form";
		}
	@PostMapping("/wishlist/save")
	public String saveWishlist(Wishlist Wishlist) {
		wishlistRepo.save(Wishlist);
		
		return "redirect:/wishlist";
	}
	

	
	@GetMapping("wishlist/edit/{id}")
	public String showEditWishlistForm(@PathVariable("id") Integer id, Model model) {
		Wishlist wishlist = wishlistRepo.findById(id).get();
		model.addAttribute("wishlist", wishlist);
	
		
		return "wishlist_form";
	}
	 
	
	@GetMapping("wishlist/delete/{id}")
	public String deleteWishlist(@PathVariable("id") Integer id, Model model) {
		wishlistRepo.deleteById(id);
		
		return "redirect:/wishlist";
	
	}
 	
}
