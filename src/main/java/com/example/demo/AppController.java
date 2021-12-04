/*
 * map all urls & html page in this class
 */
package com.example.demo;

import java.util.List;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.CreditCard;
import com.example.demo.entity.CustomUserDetails;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Controller
public class AppController {
	
	@Autowired
	private UserService service;
	
	public AppController(UserService service) {
		this.service = service;
	}

	//home page
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	//register page
	@GetMapping("/register")
	public String showSignUpForm(Model model) {
		model.addAttribute("user", new User());
		return "signup_form";
	}
	//add new user
	@PostMapping("/process_register")
	public String processRegisteration(User user) {
		service.encodePassword(user);
		service.saveUser(user);
		return "register_success";
	}

	//user profile
	@GetMapping("/user_profile")
	public String viewUserProfile(Model model, @AuthenticationPrincipal CustomUserDetails currentUser) {
		 User user = (User)service.getByEmail(currentUser.getUsername());
	     model.addAttribute("currentUser", user);
		return "users";
	}
	
	//view user editing page
	@GetMapping("/user_profile/edit_user/{id}") 
	public String viewEditUser(Model model, @PathVariable(value = "id") Long id){
		User user = service.getById(id);
		model.addAttribute("currentUser", user);
		return "user_form";
	}
	
	//update user profile
	@PostMapping("/user_profile/edit_user/{id}") 
	public String editUser(User user, RedirectAttributes redirectAttributes){
		//User user = service.getById(id);
		service.updateAccount(user);
		
		redirectAttributes.addFlashAttribute("message", "Your profile has been updated successfully!");
		return "redirect:/user_profile";
	}
	
	//user list
	@GetMapping("/user_list")
	public String viewUsersList(Model model, @Param("keyword") String keyword) {
		List<User> listUsers = service.listAll(keyword);
		model.addAttribute("listUsers", listUsers); //"listUsers" links with HTML file: <tr th:each="user:${listUsers}"> 
		model.addAttribute("keyword", keyword);
		return "user_list";
	}	
	
}
