package edu.fiu.wfan.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "users") //CREATE users table in database
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //primary key, and auto-generated by db
	private Long id;
	
	@Column(nullable = false, unique = true, length = 45) //all attrs here set not null and unique
	private String email;
	
	@Column(nullable = false, length = 20)
	private String password;
	
	@Column(nullable = true, length = 20)
	private String firstName;
	
	@Column(nullable = true, length = 20)
	private String lastName;
	
	@Column(nullable = true, length = 15)
	private String phone;
	
	@Column(nullable = true, length = 100)
	private String mailingAddress; 
	
	private boolean enabled;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private List<CreditCard> cards;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")
			)
	private Set<Role> roles = new HashSet<>();
	
	public User() {
		
	}
	
	public User(Long id) {
		this.id = id;
	}
	
	public User(String email, String password, String firstName, String lastName, String phone,
			String mailingAddress){//, String creditCard, String expire, String cvv, String billingAddress) {
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.mailingAddress = mailingAddress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMailingAddress() {
		return mailingAddress;
	}

	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}

	public List<CreditCard> getCards() {
		if(cards == null)
			cards = new ArrayList<>();
		return this.cards;
	}

	public void setCards(List<CreditCard> cards) {
		this.cards = cards;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public void addRole(Role role) {
		this.roles.add(role);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", roles=" + roles + "]";
	}
	
}