package com.example.demo.wishlist;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.product.Product;
import com.example.demo.product.ProductsRepository;


@Controller
public class WishlistController {

	@Autowired
	private WishlistRepository wishlistRepo;
	
	@Autowired
	private ProductsRepository productRepo;

	
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
	
		List<Product> listProduct = productRepo.findAll();
		model.addAttribute("listProduct", listProduct);
		
		return "wishlist_form";
	}
	 
	
	@GetMapping("wishlist/delete/{id}")
	public String deleteWishlist(@PathVariable("id") Integer id, Model model) {
		wishlistRepo.deleteById(id);
		
		return "redirect:/wishlist";
	
	}
 	@GetMapping("/wishlist/view/{id}")
	public String listWishlistItems(@PathVariable("id") Integer id, Product product, Model model) {
 		Wishlist listWishlist = wishlistRepo.findById(id).get();
 		model.addAttribute("listWishlist",listWishlist);		
 		
 		List<Product> listProducts = productRepo.findAll();
 		model.addAttribute("listProducts", listProducts);
 		
 		
 		//	wishlistRepo.save(Wishlist);

 		
		return "wishlist_items";
	
		}
/*
 * @GetMapping("/wishlist/view/save/{id}")
	public String saveListWishlistItems(@PathVariable("id") Integer id, Model model) {
 		//
 		 
 		 
 		
 		
 		//	wishlistRepo.save(Wishlist);

 		
		return "redirect:/wishlist_items";
		}
 * 
 */
 	/*
 	 * @GetMapping("/wishlist/view/delete/{id}")
 		public String deleteListWishlistItems(@PathVariable("id") Integer id, Model model) {
 	 		//
 	 		 
 	 		 
 	 		
 	 		
 	 		//	wishlistRepo.deleteById(id);

 	 		
 			return "redirect:/wishlist_items";
 			}
 	 * 
 	 */
	
}
