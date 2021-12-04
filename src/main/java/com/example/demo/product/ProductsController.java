package com.example.demo.product;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.wishlist.Wishlist;
import com.example.demo.wishlist.WishlistRepository;



@Controller
public class ProductsController {
	
	@Autowired
	private ProductsRepository productRepo;
	
	@Autowired
	private WishlistRepository wishlistRepo;

	//Creates a new product that collects the wishlist 
		@GetMapping("/products/new")
		public String showProductNewFormModel(Model model) {
			List<Wishlist> listWishlists = wishlistRepo.findAll();
			model.addAttribute("product", new Product());
			model.addAttribute("listWishlist", listWishlists);

			
			return "product_form";
	}
		//saves any changes done to the product
		@PostMapping("/products/save")
		public String saveProduct(Product product) {
			productRepo.save(product);
			return "redirect:/products";
		}
				
	//displays the list of products
	@GetMapping("/products")
		public String listProducts(Model model) {
			List<Product> listProducts = productRepo.findAll();
			model.addAttribute("listProducts", listProducts);
			
			return "products";
	
		}
	
	@GetMapping("products/edit/{id}")
	public String showEditProductForm(@PathVariable("id") Integer id, Model model) {
		Product product = productRepo.findById(id).get();
		model.addAttribute("product", product);
		
		List<Wishlist> listWishlists = wishlistRepo.findAll();
		model.addAttribute("listWishlist", listWishlists);
		
		
		return "product_form";
	}
	
	@GetMapping("products/delete/{id}")
	public String deleteProduct(@PathVariable("id") Integer id, Model model) {
		productRepo.deleteById(id);
		
		return "redirect:/products";
	
	}
	
	
}
