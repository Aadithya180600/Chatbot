package com.chatbot.chatbot;

import java.util.List;

public interface AccdetailsService {
	List<Accdetails> findAll();
	List<Accdetails> findByOcc(String occ);
	Accdetails findByAccno(String accno);
	void save(Accdetails cb);
	List<mdetails> listAll1();
	void save(mdetails cb);
	List<mdetails> findByProcessed(Boolean processed);
	void deleteaccdetails(String id);
	void deletemdetails(String id);
	mdetails findByLoannumber(String loannumber);
	mdetails update(String id,mdetails md);
	List<Acc_mdetails> combine(Boolean processed);
	List<Login> findByUsername(String username);
	void save(Login cb);
}