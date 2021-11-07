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

import com.example.ChessTourApp.model.Player;
import com.example.ChessTourApp.model.Tournament;
import com.example.ChessTourApp.model.TournamentResult;
import com.example.ChessTourApp.repository.PlayerRepository;
import com.example.ChessTourApp.repository.TournamentRepository;
import com.example.ChessTourApp.repository.TournamentResultRepository;

//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "*")

@Controller
@RequestMapping("/tour")
public class TournamentController {
	
	@Autowired
	private TournamentRepository tRepository;
	@Autowired
	private TournamentResultRepository trRepository;
	
	
	List<Tournament> tourList = new ArrayList<>();
	List<TournamentResult> tourResultList = new ArrayList<>();
	
	@GetMapping("/list")
	public String getIndex(Model model) {
		
		model.addAttribute("tour", tRepository.findAll());

		return "tourlists";
	}
	

	
	@RequestMapping(value = "/result/list")
	public @ResponseBody List<TournamentResult> listResults() {
		return trRepository.findAll() ;
	}
	
	
	@GetMapping(value = "/result/list/{id}")
	public String listTourResults(Model model,@PathVariable Long id) {
		model.addAttribute("tourResult", trRepository.findBytourid(id));
		return "tourresultlists";
	}
	
	
	@PostMapping(value = "/save")
	public void saveTour(@RequestBody() Tournament tr) {
		 tRepository.save(tr) ;
	}

	@PostMapping(value = "/result/save")
	public void saveTourResult(@RequestBody() TournamentResult tr) {
		 trRepository.save(tr) ;
	}
}
