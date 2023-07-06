package com.drazzco.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drazzco.workshopmongo.entities.User;
import com.drazzco.workshopmongo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll()
	{
		return repository.findAll();
	}
}
