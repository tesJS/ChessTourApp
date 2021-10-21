package com.example.ChessTourApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ChessTourApp.model.Player;
import com.example.ChessTourApp.repository.PlayerRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/player")
public class PlayerController {
	
	@Autowired
	private PlayerRepository pRepository;
	

	List<Player> playersList = new ArrayList<>();

	@RequestMapping(value = "/list")
	public List<Player> listPlayers() {
		return pRepository.findAll() ;
	}

	@RequestMapping(value = "/add")
	public void addPlayer(@RequestBody() Player pl) {
		 pRepository.save(pl) ;
	}
}
