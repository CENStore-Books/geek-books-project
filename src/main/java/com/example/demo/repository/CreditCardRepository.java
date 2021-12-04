package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CreditCard;
import com.example.demo.entity.User;

public interface CreditCardRepository extends JpaRepository<CreditCard, Integer>{

	//in query, the table name must be entity class name, and the field name must be the instance variable name
	@Query("SELECT c FROM CreditCard c WHERE c.card_id = ?1")
	public CreditCard findByCreditCardId(@Param("card_id")Integer cardId);  
		
	@Query("SELECT c FROM CreditCard c JOIN FETCH c.user u WHERE c.bankName LIKE %?1% AND u.id = ?2")
	public List<CreditCard> search(String keyword, Long userId);	 
}
