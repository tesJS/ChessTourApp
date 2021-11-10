package com.example.ChessTourApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.ChessTourApp.model.Tournament;

public interface TournamentRepository extends JpaRepository<Tournament,Long> {

}
