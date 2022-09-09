package com.example.ChessTourApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	
	
	
	
	//RESTful  response that gets all of the players for the logged user
	@GetMapping(value = "/api/list/{username}")
	public @ResponseBody List<Player> listPlayers(@PathVariable String username ) {
		return pRepository.findByUsernameOrderByEloDesc(username) ;
	}


	@GetMapping("/list/{username}")
	public String getIndex(@PathVariable String username,Model model) {
		
		model.addAttribute("players", pRepository.findByUsernameOrderByEloDesc(username));
		

		return "playerslist";
	}
	
	@PostMapping(value = "/add")
	public String addPlayer(Player pl) {
		 pRepository.save(pl) ;
		 return "redirect:/player/list";
	}
	//RESTful  version of saving player
	@PostMapping(value = "/api/add")
	public void addRestPlayer(@RequestBody Player pl) {
		System.out.println(pl.getUsername());
		 pRepository.save(pl) ;
		 
	}
	
	@GetMapping("/edit/{id}")
	public String editPlayer(@PathVariable Long id, Model model) {

		Player pl = pRepository.getById(id);	
		model.addAttribute("player", pl);		
		return "updateplayer";
	}
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable Long id) {

		pRepository.deleteById(id);
		return "redirect:/player/list";

	}
}
