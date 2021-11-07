package com.example.ChessTourApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.ChessTourApp.model.Player;
import com.example.ChessTourApp.repository.PlayerRepository;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/player")
public class PlayerController {
	
	@Autowired
	private PlayerRepository pRepository;
	

	List<Player> playersList = new ArrayList<>();

	@GetMapping("/list")
	public String getIndex(Model model) {
		
		model.addAttribute("players", pRepository.findAll());

		return "playerslist";
	}
	@RequestMapping(value = "/list")
	public @ResponseBody List<Player> listPlayers() {
		return pRepository.findAll() ;
	}

	@RequestMapping(value = "/add")
	public void addPlayer(@RequestBody() Player pl) {
		 pRepository.save(pl) ;
	}
}
