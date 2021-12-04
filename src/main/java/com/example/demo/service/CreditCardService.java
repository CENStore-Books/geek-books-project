package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CreditCard;
import com.example.demo.entity.User;
import com.example.demo.exception.CreditCardNotFoundException;
import com.example.demo.repository.CreditCardRepository;

@Service
@Transactional
public class CreditCardService {

	@Autowired
	private CreditCardRepository creditCardRepo;
	
	public List<CreditCard> listAllCreditCards(String keyword, Long userId) {
		if(keyword != null) {
			//System.out.println("userId = " + userId);
			return creditCardRepo.search(keyword, userId);
		}
		return (List<CreditCard>) creditCardRepo.findAll();
	}

	public void save(CreditCard card) {
		creditCardRepo.save(card);
	}
	
	public CreditCard getCardById(Integer card_id){
			return creditCardRepo.findById(card_id).get();
	}
	
	public void deleteCard(CreditCard card) throws CreditCardNotFoundException{
		//Integer countById = creditCardRepo.countById(card.getCard_id());
		if(card.getCard_id() == null || card.getCard_id() == 0) {
			throw new CreditCardNotFoundException("Could not find any credit card with ID " + card.getCard_id());
		}
		creditCardRepo.deleteById(card.getCard_id());
	}
	
}
