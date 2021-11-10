package com.example.ChessTourApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.ChessTourApp.model.TournamentResult;

public interface TournamentResultRepository extends JpaRepository<TournamentResult,Long> {
	public List<TournamentResult> findByTourid(String id);
	
}
