package com.chatbot.chatbot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccdetailsServiceImpl implements AccdetailsService{

	@Autowired private AccdetailsRepository repo;
	@Autowired private MdRepository mrepo;
	@Autowired private LoginRepository lrepo;
	@Override
	public List<Accdetails> findAll() {
		   return repo.findAll();
		}
	@Override
	public void save(Accdetails cb) {
		repo.save(cb);
	}
 	@Override
	public List<Accdetails> findByOcc(String occ) {
		return repo.findByOcc(occ);
	}
	@Override
	public List<mdetails> listAll1() {
		
		return mrepo.findAll();
	}
	@Override
	public void save(mdetails cb) {
		mrepo.save(cb);
		
	}
	@Override
	public List<mdetails> findByProcessed(Boolean processed) {
		return mrepo.findByProcessed(processed);
	}
	@Override
	public void deleteaccdetails(String id) {
		repo.deleteById(id);
	}
	@Override
	public Accdetails findByAccno(String accno) {
		return repo.findByAccno(accno);
	}
	
	@Override
	public void deletemdetails(String id) {
		mrepo.deleteById(id);
	}
	@Override
	public mdetails findByLoannumber(String loannumber) {
		return mrepo.findByLoannumber(loannumber);
	}
	@Override
	public mdetails update(String id,mdetails md) {
		 Optional<mdetails> updated = mrepo.findById(id);
		 mdetails m = null;
	     if(updated.isPresent())
	     {
	    	 m= updated.get();
	    	 m.setProcessed(md.getProcessed());
	    	 m.setAccno(md.getAccno());
	    	 m.setLoannumber(md.getLoannumber());
	    	 m.setNo_of_months(md.getNo_of_months());
	    	 m.setReason(md.getReason());
	    	 m.setType_of_loan(md.getType_of_loan()); 
	     }
	     return mrepo.save(m);
	    
	}
	
	@Override
	public List<Acc_mdetails> combine(Boolean processed) {
		List<Accdetails> acc = new ArrayList<>();
		repo.findAll().forEach(acc::add);
		List<mdetails> m=new ArrayList<>();
		mrepo.findByProcessed(processed).forEach(m::add);
		List<Acc_mdetails> amd= new ArrayList<>();
		for(mdetails i:m)
		{
			Acc_mdetails am = new Acc_mdetails();
			Accdetails a=repo.findByAccno(i.getAccno());
			am.setAccno(a.getAccno());
			am.setName(a.getName());
			am.setPhn_no(a.getPhn_no());
			am.setOcc(a.getOcc());
			am.setHave_income(a.getHave_income());
			am.setIncome(a.getIncome());
			am.setLoannumber(i.getLoannumber());
			am.setType_of_loan(i.getType_of_loan());
			am.setNo_of_months(i.getNo_of_months());
			am.setReason(i.getReason());
			am.setProcessed(i.getProcessed());
			amd.add(am);
		}
		return amd;
	
	}
	@Override
	public List<Login> findByUsername(String username) {
		return lrepo.findByUsername(username);
	}
	@Override
	public void save(Login cb) {
		lrepo.save(cb);
	}
	
}