package edu.fiu.wfan;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;

import edu.fiu.wfan.entity.Role;
import edu.fiu.wfan.entity.User;
import edu.fiu.wfan.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateNewUserWithOneRole() {
		Role roleAdmin = entityManager.find(Role.class, 1);
		User userTest = new User("test@gmail.com", "1234567890", "Test", "Staff", null, null);
		userTest.addRole(roleAdmin);
		
		User savedUser = repo.save(userTest);
		
		assertThat(savedUser.getId()).isGreaterThan(0);
		
		/*user.setEmail("test1@gmail.com");
		user.setPassword("test2021");
		user.setFirstName("Test1");
		user.setLastName("T1");
		
		User savedUser = repo.save(user);
		
		User existUser = entityManager.find(User.class, savedUser.getId());
		
		assertThat(existUser.getEmail()).isEqualTo(user.getEmail());*/
	}
	@Test
	public void testCreateNewUserWithTwoRole() {
		User userRavi = new User("ravi@gmail.com", "1234567890", "Ravi", "Kumar", null, null);
		Role userAdmin = new Role(1);
		Role bookAdmin = new Role(2);
		
		userRavi.addRole(userAdmin);
		userRavi.addRole(bookAdmin);
		
		User savedUser = repo.save(userRavi);
		
		assertThat(savedUser.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testListAllUsers() {
		Iterable<User> listUsers = repo.findAll();
		listUsers.forEach(user -> System.out.println(user));
		
	}
	
	@Test
	public void testGetUserById() {
		User user = repo.findById(1l).get();
		System.out.println(user);
		assertThat(user).isNotNull();
	}
	
	@Test
	public void testFindUserByEmail() { //check if can find email in db
		String email = "wfan003@fiu.edu";
		
		User user = repo.findByEmail(email);
		assertThat(user).isNotNull();
	}
	
	@Test
	public void testUpdateUserDetails() {
		User user = repo.findById(25l).get(); //create an object = repo.findByPK().get();  get corresponding row by primary key
		user.setEnabled(true); //use the object method do something
		user.setEmail("test@updated.com");
		
		repo.save(user); //save this object into repository(db)
	}
	
	@Test
	public void testUpdateUserRoles() {
		User user = repo.findById(26l).get();
		Role userAdmin = new Role(2);
		Role bookAdmin = new Role(1);
		user.getRoles().remove(userAdmin);
		user.addRole(bookAdmin);
		
		repo.save(user);
		
	}
	
	@Test
	public void testDeleteUser() {
		Long userId = 25l;
		repo.deleteById(userId);
	}
	
	@Test
	public void testSearchUsers() {
		String keyword = "wfan";	
		
		List<User> users = repo.search(keyword);
				
		users.forEach(user -> System.out.println(user));
		
	}

}
