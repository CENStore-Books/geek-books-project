package edu.fiu.wfan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.fiu.wfan.entity.CreditCard;
import edu.fiu.wfan.entity.User;

public interface CreditCardRepository extends JpaRepository<CreditCard, Integer>{

	//in query, the table name must be entity class name, and the field name must be the instance variable name
	@Query("SELECT c FROM CreditCard c WHERE c.card_id = ?1")
	public CreditCard findByCreditCardId(@Param("card_id")Integer cardId);  
		
	@Query("SELECT c FROM CreditCard c JOIN User u ON (c.id = u.id) WHERE c.bankName LIKE %?1% AND u.id = ?2")
	public List<CreditCard> search(String keyword, Long userId);
	
	//@Query("SELECT t FROM Thing t WHERE t.fooIn = ?1 AND t.bar = ?2")
	//ThingEntity findByFooInAndBar(String fooIn, String bar);
	
	//List<CreditCard> findByKeywordsIn(String keyword);
	
	//@Query("SELECT c FROM CreditCard c WHERE c.user_id = ?1")
	//public List<CreditCard> findByUserId(@Param("user_id")Long user_id);
	 
}
