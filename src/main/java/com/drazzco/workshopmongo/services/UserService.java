package com.drazzco.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drazzco.workshopmongo.dto.UserDTO;
import com.drazzco.workshopmongo.entities.User;
import com.drazzco.workshopmongo.repositories.UserRepository;
import com.drazzco.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll()
	{
		return repository.findAll();
	}
	
	public User findById(String id)
	{
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(id));
	}
	
	public User insert(User obj)
	{
		return repository.save(obj);
	}
	
	public void delete(String id)
	{
		findById(id);
		repository.deleteById(id);
	}
	
	public User fromDTO(UserDTO dto)
	{
		return new User(dto.getId(), dto.getName(), dto.getEmail());
	}
	
	public User update(User obj)
	{
		User entity = findById(obj.getId());
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) 
	{
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
	}
}
