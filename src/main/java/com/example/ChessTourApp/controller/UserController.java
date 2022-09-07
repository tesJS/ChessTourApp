package com.example.ChessTourApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

import com.example.ChessTourApp.model.CheckUser;
import com.example.ChessTourApp.model.Player;
import com.example.ChessTourApp.repository.UserRepository;
import com.example.ChessTourApp.model.User;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository uRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping(value = "/add")
	public void addRestUser(@RequestBody User user) {

		user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));

		uRepository.save(user);

	}
	@RequestMapping("/check")
	public CheckUser getUser(@RequestBody User user) {

		CheckUser checkUser = null;
		User dbUser = uRepository.findByUsername(user.getUsername());
		if (dbUser == null)
			checkUser = new CheckUser(null, false);
		else {
			System.out.println(user);
			boolean userPasswordMatches = passwordEncoder.matches(user.getPasswordHash(), dbUser.getPasswordHash());
			checkUser = new CheckUser(dbUser, userPasswordMatches);
		}

		return checkUser;
	}

	@GetMapping("/check/{username}/{password}")
	public CheckUser checkUser(@PathVariable String username,@PathVariable String password) {

		CheckUser checkUser = null;
		User dbUser = uRepository.findByUsername(username);
		if (dbUser == null)
			checkUser = new CheckUser(null, false);
		else {
			boolean userPasswordMatches = passwordEncoder.matches(password, dbUser.getPasswordHash());
			checkUser = new CheckUser(dbUser, userPasswordMatches);
		}

		return checkUser;
	}
	@GetMapping("/getuser/{username}")
	public User getTheUser(@PathVariable String username) {

		User user=uRepository.findByUsername(username);
		return user;
	}
	

}
