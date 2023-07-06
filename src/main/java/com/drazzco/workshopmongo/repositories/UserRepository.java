package com.drazzco.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.drazzco.workshopmongo.entities.User;

public interface UserRepository extends MongoRepository<User, String>{

}
