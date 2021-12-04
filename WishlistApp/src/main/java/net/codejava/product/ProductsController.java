package net.codejava.product;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.codejava.wishlist.Wishlist;
import net.codejava.wishlist.WishlistRepository;



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
	//Edits fields of product and wishlist
	@GetMapping("products/edit/{id}")
	public String showEditProductForm(@PathVariable("id") Integer id, Model model) {
		Product listProducts = productRepo.findById(id).get();
		model.addAttribute("product", listProducts);
		
		List<Wishlist> listWishlists = wishlistRepo.findAll();
		model.addAttribute("listWishlist", listWishlists);
		
		
		return "product_form";
	}
	
	//Deletes a product
	@GetMapping("products/delete/{id}")
	public String deleteProduct(@PathVariable("id") Integer id, Model model) {

		productRepo.deleteById(id);
		
		return "redirect:/products";
	
	} 
	
	//Displays all items in specified wishlist
	@GetMapping("/products/wishlist/view/{wishlist_id}")
	public String listWishlistItems(@PathVariable("wishlist_id") Integer wishlist_id,  Model model) {
		
		model.addAttribute("listProducts", productRepo.findAllByID(wishlist_id));
		
		
		return "wishlist_products";
	}
		//In process
	@GetMapping("/products/wishlist/view/addtoshoppingcart")
 		public String addToShoppingCart(Model model, Product product) {
	 	
		//ist<Product> listProducts = productRepo.findAll();
		//productRepo.
	 
	 	return "product_shopping_cart";
	 
	}
	
}
