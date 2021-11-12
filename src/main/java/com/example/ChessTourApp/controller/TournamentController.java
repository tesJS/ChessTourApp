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
import com.example.ChessTourApp.service.TourResultSwitch;

//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "*")

@Controller
@RequestMapping("/tour")
public class TournamentController {
	
	@Autowired
	private PlayerRepository pRepository;
	@Autowired
	private TournamentRepository tRepository;
	@Autowired
	private TournamentResultRepository trRepository;
	
	
	List<Tournament> tourList = new ArrayList<>();
	List<TournamentResult> tourResultList = new ArrayList<>();
	List<Player> plr = new ArrayList<>();
	
	
	//For the Tournament List Page 
	
	@GetMapping("/list")
	public String getIndex(Model model) {
		
		model.addAttribute("tour", tRepository.findAll());

		return "tourlists";
	}
	
	
	@GetMapping("/edit/{id}")
	public String editTournament(@PathVariable Long id, Model model) {

		Tournament tr = tRepository.getById(id);
		model.addAttribute("tour", tr);		
		return "updatetour";
	}
	
	
	@PostMapping(value = "/save")
	public String saveTour(Tournament tr) {
		 tRepository.save(tr) ;
		 return "redirect:/tour/list";
		 
	}
	// RESTful  version of saving Tournament
	@PostMapping(value = "api/save")
	public void saveRestTour(@RequestBody Tournament tr) {
		 tRepository.save(tr) ;		 
		 
	}
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable Long id) {

		tRepository.deleteById(id);
		return "redirect:/player/list";

	}
	// For the Corresponding Tournaments Results Page which is linked in the Tournaments List Page
	@GetMapping("/result/{id}")
	public String getTournamentResult(@PathVariable String id, Model model) {

//		List<TournamentResult> tr = trRepository.findByTourid(id);
		List<TournamentResult> trl = trRepository.findByTouridOrderByScoreDesc(id);
		List<TourResultSwitch> tsl = new ArrayList<>();		
		List<Player> plrs = pRepository.findAll();
		
		//to switch tournamentResult player id with the respective player name
		for(TournamentResult tr: trl ) {
			for(Player plr:plrs) {
				if(tr.getPlayer_id()==plr.getId()) {
					TourResultSwitch trs=new TourResultSwitch(plr.getName(),tr.getTourid(),tr.getScore());
					trs.setId(tr.getId());
					tsl.add(trs);
				}
			}
		}
		model.addAttribute("tourResults", tsl);
		
		return "tourresultlist";
	}
	
	@GetMapping("/result/edit/{id}")
	public String editTournamentResult(@PathVariable Long id, Model model) {

		TournamentResult tr = trRepository.getById(id);
		model.addAttribute("tourResult", tr);		
		return "updatetourresult";
	}
	
	@PostMapping(value = "/result/save")
	public String saveTourResult(TournamentResult tr) {
		 trRepository.save(tr) ;
		 return "redirect:/tour/list";
		 
	}
// RESTful  version of saving Tournament
	@PostMapping(value = "/api/result/save")
	public void saveRestTourResult(@RequestBody TournamentResult tr) {
		 trRepository.save(tr) ;	 
		 
	}
		
	
}
