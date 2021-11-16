package com.example.ChessTourApp.service;

public class TourResultSwitch {
	private String player_name;
	private Long id;
	private String tourid;
	private String score;
	public TourResultSwitch(Long id,String player_name, String tourid, String score) {
		super();
		this.player_name = player_name;
		
		this.tourid = tourid;
		this.score = score;
	}
	public String getPlayer_name() {
		return player_name;
	}
	public void setPlayer_name(String player_name) {
		this.player_name = player_name;
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
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	
	
}
