package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.CreditCard;
import com.example.demo.entity.CustomUserDetails;
import com.example.demo.entity.User;
import com.example.demo.exception.CreditCardNotFoundException;
import com.example.demo.service.CreditCardService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/user_profile")
public class CreditCardController {
	
	@Autowired
	private CreditCardService creditCardService;
	
	@Autowired
	private UserService userService;
	
	public CreditCardController(CreditCardService creditCardService) {
		this.creditCardService = creditCardService;
	}

	//credit card list
	@GetMapping("/credit_card_list")
	public String viewCreditCardList(Model model, @Param("keyword") String keyword, @AuthenticationPrincipal CustomUserDetails currentUser) {
		User user = userService.getByEmail(currentUser.getUsername());
		List<CreditCard> listCreditCards = user.getCards(); //only show that user's credit card list
		if(keyword != null) {
			listCreditCards = creditCardService.listAllCreditCards(keyword, user.getId());
		}
		model.addAttribute("listCreditCards", listCreditCards);
		model.addAttribute("keyword", keyword);
		return "credit_card_list";
	}

	//show card form
	@GetMapping("/credit_card_list/add")
	public String viewAddCreditCard(Model model) {
		CreditCard card = new CreditCard();
		model.addAttribute("card", card);
		return "credit_card_form";
	}
	
	//add card
	@PostMapping("/credit_card_list/save")
	public String saveCreditCard(@ModelAttribute CreditCard card, @AuthenticationPrincipal CustomUserDetails currentUser) {
		User user = userService.getByEmail(currentUser.getUsername());
		card.setUser(user);
		creditCardService.save(card);
		return "redirect:/user_profile/credit_card_list";
	}
	
	//delete card
	@GetMapping("/credit_card_list/delete/{card_id}")
	public String deleteCreditCard(@PathVariable("card_id")Integer card_id, RedirectAttributes redirectAttributes) throws CreditCardNotFoundException{
		try {
			CreditCard card = creditCardService.getCardById(card_id);
			creditCardService.deleteCard(card);
			redirectAttributes.addFlashAttribute("message", "The credit card has been deleted successfully");
		}catch(CreditCardNotFoundException ex) {
			redirectAttributes.addFlashAttribute("message", ex.getMessage());
		}
		return "redirect:/user_profile/credit_card_list";
	}
	
}
