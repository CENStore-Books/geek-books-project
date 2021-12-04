package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "credit_cards")
public class CreditCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer card_id;
	
	@Column(nullable = true, length = 50) 
	private String bankName;
	
	@Column(nullable = true, unique = true, length = 16) 
	private Long cardNumber;
	
	@Column(nullable = true, length = 5) 
	private String expireDate;
	
	@Column(nullable = true, length = 3)
	private Integer cvv;
	
	@Column(nullable = true, length = 100) 
	private String billingAddress;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = true)
	private User user;

	public Integer getCard_id() {
		return card_id;
	}

	public void setCard_id(Integer card_id) {
		this.card_id = card_id;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Long getUserId() {
		return user.getId();
	}

	@Override
	public String toString() {
		return "CreditCard [card_id=" + card_id + ", bankName=" + bankName + ", cardNumber=" + cardNumber
				+ ", expireDate=" + expireDate + ", cvv=" + cvv + ", billingAddress=" + billingAddress + "]";
	}

}
