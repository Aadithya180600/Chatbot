package com.chatbot.chatbot;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoginRepository extends MongoRepository<Login,String> {

	List<Login> findByUsername(String username);

}