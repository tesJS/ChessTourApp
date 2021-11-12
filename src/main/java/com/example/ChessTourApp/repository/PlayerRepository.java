package com.example.ChessTourApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ChessTourApp.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository <Player,Long> {
	public List<Player> findAllByOrderByEloDesc();
	public Player findByName(String name);

}
