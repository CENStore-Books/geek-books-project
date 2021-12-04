package net.codejava;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WishlistAppController {

	@GetMapping("/windex")
	public String viewHomePage() {
		return "wishlistindex";
	}
	
	
}
