package com.chatbot.chatbot;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccdetailsRepository extends MongoRepository<Accdetails, String>{
	List<Accdetails> findByOcc(String occ);
	Accdetails findByAccno(String accno);
}