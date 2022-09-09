package com.example.ChessTourApp.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tournamentresult")
public class TournamentResult {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tournament_sequence")
	private Long id;	
	private Long player_id;
	private String tourid;
	private String score;
	
//	
//	@ManyToOne
//    @JoinColumn(name = "id")
//    Player player;
//
//    @ManyToOne
//    @JoinColumn(name = "tourid")
//    Tournament  tournament;
	
	public TournamentResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TournamentResult(Long player_id, String tourid, String score,String username) {
		super();
		this.player_id = player_id;
		this.tourid = tourid;
		this.score = score;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(Long player_id) {
		this.player_id = player_id;
	}

	public String getTourid() {
		return tourid;
	}

	public void setTourid(String tourid) {
		this.tourid = tourid;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	

	

	
	
}
