package com.example.ChessTourApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;


@CrossOrigin(origins = {"http://chesstourapp.com","http://www.chesstourapp.com",
		"http://chesstourapp.com.s3-website.eu-north-1.amazonaws.com"})
@Controller
public class IndexController {
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/logout")
	public String logout() {
		return "redirect:/login";
	}

}
