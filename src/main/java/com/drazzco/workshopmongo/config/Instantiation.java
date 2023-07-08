package com.drazzco.workshopmongo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.drazzco.workshopmongo.entities.Post;
import com.drazzco.workshopmongo.entities.User;
import com.drazzco.workshopmongo.repositories.PostRepository;
import com.drazzco.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com");
		u1.setPassword("123aba");
		User u2 = new User(null, "Alex Green", "alex@gmail.com");
		u2.setPassword("a1b2c3");
		User u3 = new User(null, "Bob Grey", "bob@gmail.com");
		u3.setPassword("158962");
		User u4 = new User(null, "Test", "test@gmail.com");
		u4.setPassword("666fff");
		
		Post p1 = new Post(null, Instant.parse("2019-06-20T19:53:07Z"), "Partiu viagem!", "Vou viajar para o exterior!", u2);
		Post p2 = new Post(null, Instant.parse("2019-07-05T14:35:52Z"), "Bom dia!", "Acordei...", u3);
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
		postRepository.saveAll(Arrays.asList(p1, p2));
	}

}
