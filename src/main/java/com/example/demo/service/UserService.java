package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public List<User> listAll(String keyword) {
		if(keyword != null) {
			return repo.search(keyword);
		}
		return  (List<User>) repo.findAll();
	}

	public User getByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	public User getById(Long id) {
		return repo.findById(id).get();
	}
	
	public User updateAccount(User userInForm) {
		User userInDB = repo.findById(userInForm.getId()).get();
		if(!userInForm.getPassword().isEmpty() || !(userInForm.getPassword()== null)) {
			userInDB.setPassword(userInForm.getPassword());
			encodePassword(userInDB);
		}
		//System.out.println("current password is: " + userInDB.getPassword());
		
		if(userInForm.getFirstName() != null) {
			userInDB.setFirstName(userInForm.getFirstName());
		}
		
		if(userInForm.getLastName() != null) {
			userInDB.setLastName(userInForm.getLastName());
		}
		
		if(userInForm.getPhone() != null) {
			userInDB.setPhone(userInForm.getPhone());
		}
		
		if(userInForm.getMailingAddress() != null) {
			userInDB.setMailingAddress(userInForm.getMailingAddress());
		}
		
		return repo.save(userInDB);
	}
	
	public void saveUser(User user) {
		repo.save(user);
	}
	
	public void deleteById(Long id) {
		repo.deleteById(id);
	}
	
	public void encodePassword(User user) {
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
	}
}
