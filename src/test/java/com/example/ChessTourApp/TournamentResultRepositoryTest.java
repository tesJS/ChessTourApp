package com.example.ChessTourApp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ChessTourApp.model.TournamentResult;
import com.example.ChessTourApp.repository.TournamentResultRepository;

@SpringBootTest
public class TournamentResultRepositoryTest {
	
	@Autowired
	 private TournamentResultRepository trRepository;
	
	
	 @Test
	 public void createTournamentResult() {
		  
		 TournamentResult tr = new TournamentResult(152L,"HSL123","HSK11","3");
		 trRepository.save(tr);
		 assertThat(tr.getTourid()=="HSK225");
	}
	 @Test
	 public void searchTournamentResult() {
		 Long id=1603L;
		 TournamentResult tr = trRepository.getById(id);		
		 assertThat(tr).isInstanceOf(TournamentResult.class);
	}
	
	 @Test
	 public void deleteTournamentResult() {
		 Long id=1604L;
		 trRepository.deleteById(id);	
		 Boolean tour = trRepository.existsById(id);
		 assertThat(tour==null);
	}
	 

	
}
