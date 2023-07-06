package com.drazzco.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.drazzco.workshopmongo.entities.User;
import com.drazzco.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com");
		u1.setPassword("123aba");
		User u2 = new User(null, "Alex Green", "alex@gmail.com");
		u2.setPassword("a1b2c3");
		User u3 = new User(null, "Bob Grey", "bob@gmail.com");
		u3.setPassword("158962");
		User u4 = new User(null, "Test", "test@gmail.com");
		u4.setPassword("666fff");
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
	}

}
