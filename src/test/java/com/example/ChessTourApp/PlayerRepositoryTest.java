package com.example.ChessTourApp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ChessTourApp.model.Player;
import com.example.ChessTourApp.repository.PlayerRepository;

@SpringBootTest
public class PlayerRepositoryTest {
	@Autowired
	private PlayerRepository pRepository;
	
	 @Test
	 public void createNewPlayer() {
		  
		 Player plr = new Player("Frank Ribery", "1888","Ethiopian Chess Federation","user");
		 pRepository.save(plr);
		 assertThat(plr.getElo()=="1888");
	}
	 @Test
	 public void searchPlayer() {
		 Long id=103L;
		 Player plr = pRepository.getById(id);			
		 assertThat(plr).isInstanceOf(Player.class);
	}
	 @Test
	 public void deleteUser() {
		 Long id=102L;
		 pRepository.deleteById(id);	
		 Boolean user = pRepository.existsById(id);
		 assertThat(!user);
	}

}
