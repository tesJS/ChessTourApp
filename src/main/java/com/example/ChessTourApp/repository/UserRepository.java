package com.example.ChessTourApp.repository;

import java.util.List;
import com.example.ChessTourApp.model.User;
import org.springframework.data.repository.CrudRepository;



public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}