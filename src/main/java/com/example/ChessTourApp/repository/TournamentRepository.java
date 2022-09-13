package com.example.ChessTourApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ChessTourApp.model.Tournament;

public interface TournamentRepository extends JpaRepository<Tournament,Long> {

	public Tournament findByUsername(String username);
	public void deleteByTourid(String id);
	public Boolean existsByTourid(String id);
}
