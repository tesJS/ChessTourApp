package com.example.ChessTourApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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

	// For the Tournament List Page

	@GetMapping("/list")
	public String getIndex(Model model) {
		String username=SecurityContextHolder.getContext().getAuthentication().getName();
		model.addAttribute("tour", tRepository.findByUsername(username));

		return "tourlists";
	}

	@GetMapping("/edit/{id}")
	public String editTournament(@PathVariable Long id, Model model) {
		String username=SecurityContextHolder.getContext().getAuthentication().getName();
		Tournament tr = tRepository.getById(id);
		tr.setUserName(username);
		model.addAttribute("tour", tr);
		return "updatetour";
	}

	@PostMapping(value = "/save")
	public String saveTour(Tournament tr) {
		tRepository.save(tr);
		return "redirect:/tour/list";

	}

	// RESTful version of saving Tournament
	@PostMapping(value = "api/save")
	public void saveRestTour(@RequestBody Tournament tr) {
		tRepository.save(tr);

	}

	@GetMapping("/delete/{id}")
	public String deleteTournament(@PathVariable Long id) {
		Tournament tr= tRepository.getById(id);
		List<TournamentResult> tsl = trRepository.findByTourid(tr.getTourid());
		for(TournamentResult tour: tsl) {
			trRepository.delete(tour);
		}
		tRepository.deleteById(id);
		return "redirect:/tour/list";

	}

	// For the Corresponding Tournaments Results Page which is linked in the
	// Tournaments List Page
	@GetMapping("/result/{id}")
	public String getTourResult(@PathVariable String id, Model model) {

		int counter = 0;
		List<TournamentResult> tsl = trRepository.findByTouridOrderByScoreDesc(id);
		List<Player> plrs = pRepository.findAll();
		List<TourResultSwitch> trsl = new ArrayList<>();// TourResultSwitch class is helper class to convert player id
														// to player name

		// the loop populates TourResultSwitch list trsl with TourResultSwitch to fill
		// up the necessary info for the tourresultslist page
		for (TournamentResult tr : tsl) {
			for (Player plr : plrs) {
				if ((tr.getPlayer_id().equals(plr.getId()))) {
					counter++;

					trsl.add(new TourResultSwitch(plr.getName(), tr.getId(), tr.getTourid(), tr.getScore()));

				}

			}
		}

		model.addAttribute("tourResults", trsl);
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
		trRepository.save(tr);
		return "redirect:/tour/result/" + tr.getTourid();

	}

	@GetMapping("/result/delete/{id}")
	public String deleteTournamentResult(@PathVariable Long id) {
		TournamentResult tourResult = trRepository.getById(id);
		String tourid = tourResult.getTourid();
		trRepository.deleteById(id);
		return "redirect:/tour/result/" + tourid;

	}

// RESTful  version of saving TournamentResult
	@PostMapping(value = "/api/result/save")
	public void saveRestTourResult(@RequestBody TournamentResult tr) {
		trRepository.save(tr);

	}

}
