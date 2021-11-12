package com.example.ChessTourApp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import com.example.ChessTourApp.model.User;
import com.example.ChessTourApp.repository.UserRepository;



@SpringBootTest
public class UserRepositoryTest {
	
	@Autowired
	 private UserRepository urepository;
	
	
	 @Test
	 public void createNewUser() {
		  
		 User user = new User("FrankRibery", "20dfssf4535gdg53324232334","User");
		 urepository.save(user);
		 assertThat(user.getUsername()=="FrankRibery");
	}
	 @Test
	 public void searchUser() {
		 String userName="user";
		 User user = urepository.findByUsername(userName);			
		 assertThat(user).isInstanceOf(User.class);
	}
	 @Test
	 public void deleteUser() {
		 Long id=1L;
		 urepository.deleteById(id);	
		 Boolean user = urepository.existsById(id);
		 assertThat(user);
	}
	 

}
