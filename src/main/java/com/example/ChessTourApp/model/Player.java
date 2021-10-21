package com.example.ChessTourApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_sequence")
	private Long id;	
	private String name;	
	private String elo;	
	private String club;
	
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Player(String name, String elo, String club) {
		super();
		this.name = name;
		this.elo = elo;
		this.club = club;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getElo() {
		return elo;
	}
	public void setElo(String elo) {
		this.elo = elo;
	}
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
	
	

}