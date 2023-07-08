package com.drazzco.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.drazzco.workshopmongo.entities.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}
