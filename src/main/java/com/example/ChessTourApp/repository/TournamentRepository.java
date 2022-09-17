package com.example.ChessTourApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ChessTourApp.model.Tournament;

import java.util.List;

public interface TournamentRepository extends JpaRepository<Tournament,Long> {

	public List<Tournament> findByUsername(String username);
	public Tournament findByTourid(String tourid);
	public void deleteByTourid(String id);
	public Boolean existsByTourid(String id);
}
