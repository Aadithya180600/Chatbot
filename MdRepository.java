package com.chatbot.chatbot;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MdRepository extends MongoRepository<mdetails, String> {
	List<mdetails> findByProcessed(Boolean processed);
	mdetails findByLoannumber(String loannumber);
}