package com.example.ChessTourApp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ChessTourApp.model.Tournament;
import com.example.ChessTourApp.repository.TournamentRepository;

import java.util.List;

@SpringBootTest
public class TournamenRepositoryTest {
	@Autowired
	 private TournamentRepository tRepository;
	
	
	 @Test
	 public void createNewUser() {
		  
		 Tournament tr = new Tournament(44L,"a test tournament ","11","HSK225","user");
		 tRepository.save(tr);
		 assertThat(tr.getTourid()=="HSK22");
	}
	 @Test
	 public void searchTournament() {
		 String tourid="HSK221";
		 List<Tournament> tr = tRepository.findByUsername(tourid);
		 assertThat(tr).isInstanceOf(Tournament.class);
	}
	
	 @Test
	 public void deleteTournament() {
		 Long id=1702L;
		 tRepository.deleteById(id);	
		 Boolean tour = tRepository.existsById(id);
		 assertThat(tour==null);
	}
	 


}
