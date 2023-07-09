package com.drazzco.workshopmongo.config;

import java.time.Instant;
import java.util.Arrays;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.drazzco.workshopmongo.dto.AuthorDTO;
import com.drazzco.workshopmongo.dto.CommentDTO;
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
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
		
		Post p1 = new Post(null, Instant.parse("2019-06-20T19:53:07Z"), "Partiu viagem!", "Vou viajar para o exterior!", new AuthorDTO(u2));
		Post p2 = new Post(null, Instant.parse("2019-07-05T07:35:52Z"), "Bom dia!", "Acordei...", new AuthorDTO(u3));
		
		CommentDTO c1 = new CommentDTO("Boa viagem!", Instant.parse("2019-06-21T07:41:35Z"), new AuthorDTO(u1));
		CommentDTO c2 = new CommentDTO("Aproveite!", Instant.parse("2019-06-21T08:01:47Z"), new AuthorDTO(u3));
		CommentDTO c3 = new CommentDTO("Tenha um bom dia!", Instant.parse("2019-07-05T08:04:12Z"), new AuthorDTO(u1));
		
		p1.setComments(Set.of(c1, c2));
		p2.setComments(Set.of(c3));
		
		postRepository.saveAll(Arrays.asList(p1, p2));
		
		u2.setPosts(Set.of(p1));
		userRepository.save(u2);
		u3.setPosts(Set.of(p2));
		userRepository.save(u3);
	}

}
