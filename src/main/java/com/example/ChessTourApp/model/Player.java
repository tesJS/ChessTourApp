package com.example.ChessTourApp.model;
import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Player {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
	private Long id;	
	private String name;	
	private String elo;	
	private String club;
	private String username;
	
//	@OneToMany(mappedBy = "Player")
//	 private  List<TournamentResult> results;

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Player(String name, String elo, String club, String username) {
		super();
		this.name = name;
		this.elo = elo;
		this.club = club;
		this.username=username;
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
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
