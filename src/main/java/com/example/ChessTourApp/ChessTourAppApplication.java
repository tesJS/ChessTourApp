package com.example.ChessTourApp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.ChessTourApp.model.User;
import com.example.ChessTourApp.repository.UserRepository;

@SpringBootApplication
public class ChessTourAppApplication {

	private static final Logger log = LoggerFactory.getLogger(ChessTourAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ChessTourAppApplication.class, args);
	}

	/*
	 * @Bean public CommandLineRunner commandLineRunner(UserRepository urepository)
	 * { return args -> {
	 * 
	 * 
	 * // Create users: USER/ADMIN/GUEST
	 * 
	 * 
	 * User user1 = new
	 * User("user","$2a$10$FTitFaX3rpxSX8yxF5UUMeV3TKWerl7mEQGTdL5ioO9zN11hvybzC",
	 * "USER");
	 * 
	 * 
	 * User user2 = new
	 * User("admin","$2a$10$IZohXY.II2cY.zp.RRHzveFC6tp02LMZAbUjrWOR.SdI04pU8foDu",
	 * "ADMIN"); User user3 = new
	 * User("guest","$2a$10$1loWr3UjodXznumrqLkCFOJoxprWNzE61S6FimPF.ZOHAbuW7Z1WG",
	 * "GUEST");
	 * 
	 * urepository.save(user1); urepository.save(user2); urepository.save(user3);
	 * 
	 * log.info("fetch all users"); for (User user : urepository.findAll()) {
	 * log.info(user.toString()); }
	 * 
	 * 
	 * }; }
	 * 
	 */

}
