package com.drazzco.workshopmongo.services;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drazzco.workshopmongo.entities.Post;
import com.drazzco.workshopmongo.repositories.PostRepository;
import com.drazzco.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;
	
	public Post findById(String id)
	{
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(id));
	}
	
	public List<Post> findByTitle(String text)
	{
		return repository.searchTitle(text);
		//return repository.findByTitleContainingIgnoreCase(text);
	}
	
	public List<Post> fullSearch(String text, Instant minDate, Instant maxDate)
	{
		maxDate = maxDate.plus(1, ChronoUnit.DAYS);
		return repository.fullSearch(text, minDate, maxDate);
	}
}
