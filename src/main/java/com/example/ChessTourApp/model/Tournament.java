package com.example.ChessTourApp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Tournament {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tournament_sequence")
	private Long id;	
	private String tourid;
	private Long noplayers;	
	private String tourdetails;	
	private String norounds;
	private String username;
	
//	@OneToMany(mappedBy = "tournament")
//	 private  List<TournamentResult> results;
	
	public Tournament() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tournament(Long noplayers, String tourdetails, String norounds,String tourid,String username) {
		super();
		this.noplayers = noplayers;
		this.tourdetails = tourdetails;
		this.norounds = norounds;
		this.tourid=tourid;
		this.username=username;
	}
	
	
	public Long getNoplayers() {
		return noplayers;
	}
	public void setNoplayers(Long noplayers) {
		this.noplayers = noplayers;
	}
	public String getTourdetails() {
		return tourdetails;
	}
	public void setTourdetails(String tourdetails) {
		this.tourdetails = tourdetails;
	}
	public String getNorounds() {
		return norounds;
	}
	public void setNorounds(String norounds) {
		this.norounds = norounds;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTourid() {
		return tourid;
	}
	public void setTourid(String tourid) {
		this.tourid = tourid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	

}
