package com.chatbot.chatbot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(path="/lmcb")
@CrossOrigin(origins="http://localhost:8080")
public class AccdetailsController 
{
	@Autowired private AccdetailsService service;
	
	//retrieving all the information from Account details collection
	@GetMapping("/getaccdetails")
	public List<Accdetails> list() {
	   return service.findAll();
	}
	
	//Posting Account details
	@PostMapping(value="/saveaccdetails",consumes = "application/json")
	public ResponseEntity<String> save1(@RequestBody Accdetails cb) {
        service.save(cb);
        return new ResponseEntity<String>("Added successfully", HttpStatus.OK);
    }
	
	//Posting Account details using account number
	@PostMapping(value="/saveaccdetails/accno/{accno}",consumes = "application/json")
	public ResponseEntity<String> save(@RequestBody Accdetails cb,@PathVariable("accno") String accno) {
		if(service.findByAccno(accno)==null) {
			service.save(cb);
			return new ResponseEntity<String>("Added successfully", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Account number already existed", HttpStatus.OK);
		}
	       
	}
	
	//Retrieving all the Account details from occupation of the user
	@GetMapping(value="getaccdetails/occ/{occ}")
	public List<Accdetails> findByOcc(@PathVariable("occ") String occ) {
		return service.findByOcc(occ);
	}
	
	//Retrieving all the Account details from account number
		@GetMapping(value="getaccdetails/accno/{accno}")
		public List<Accdetails> findByAccno(@PathVariable("accno") String accno) {
			List <Accdetails> l= new ArrayList<Accdetails>();
			Accdetails a=service.findByAccno(accno);
			l.add(a);
			return l;
		}
	
	//Retrieving all the Moratorium details from processed
	@GetMapping(value="getmdetails/processed/{processed}")
	public List<mdetails> findByProcessed(@PathVariable("processed") Boolean processed) {
		return service.findByProcessed(processed);
	}
	
	//Posting moratorium details using loan number
	@PostMapping(value="/savemdetails/loannumber/{loannumber}",consumes = "application/json")
	public ResponseEntity<String> save(@RequestBody mdetails cb,@PathVariable("loannumber") String loannumber) {
		if(service.findByLoannumber(loannumber)==null) {
			service.save(cb);
            return new ResponseEntity<String>("Added successfully", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Loan number already existed", HttpStatus.OK);
		}
    }
	
	//Getting moratorium details
	@GetMapping("/getmdetails")
	public List<mdetails> list1(){
		return service.listAll1();
	}
	
	//Posting moratorium details
	@PostMapping(value="/savemdetails",consumes = "application/json")
	public ResponseEntity<String> save(@RequestBody mdetails cb) {
        service.save(cb);
        return new ResponseEntity<String>("Added successfully", HttpStatus.OK);
    }
	//updating processed
	@PutMapping(value="/updateprocessed/{loannumber}",consumes = "application/json")
	public ResponseEntity<String> update(@RequestBody mdetails cb,@PathVariable("loannumber") String loannumber) {
		service.update(service.findByLoannumber(loannumber).getId(), cb);
		return new ResponseEntity<String>("Updated successfully", HttpStatus.OK);
	}
	
	//deleting from account details using account number
	@DeleteMapping(value = "/deleteaccdetails/{accno}")
    public void deleteaccdetails(@PathVariable String accno) {
        service.deleteaccdetails(service.findByAccno(accno).getId());
    }
	
	//deleting from moratorium details using loan number
	@DeleteMapping(value = "/deletemdetails/{loannumber}")
    public void deletemdetails(@PathVariable String loannumber) {
        service.deletemdetails(service.findByLoannumber(loannumber).getId());
    }
	//Retrieving all the details from processed
	@GetMapping(value="getalldetails/processed/{processed}")
	public List<Acc_mdetails> alld(@PathVariable("processed") Boolean processed) {
		return service.combine(processed);
	}
	//getting login details using username
	@GetMapping(value="getlogindetails/username/{username}")
	public List<Login> findByUsername(@PathVariable("username") String username) {
		return service.findByUsername(username);
	}
	
	//saving login details
	@PostMapping(value="/savelogindetails",consumes = "application/json")
	public ResponseEntity<String> savelogin(@RequestBody Login cb) {
        service.save(cb);
        return new ResponseEntity<String>("Added successfully", HttpStatus.OK);
    }
	//checking the passwords
		@GetMapping(value="checklogindetails/{username}/{password}")
		public ResponseEntity<String> checkpassword(@PathVariable("username") String username,@PathVariable("password") String password) {
			List<Login> l=service.findByUsername(username);
			for(Login login:l)
			{
				String s=login.getPassword();
				System.out.println(s);
				String p=password;
				System.out.println(p);
				if(s.equals(password))
				{
					return new ResponseEntity<String>("passwords matched", HttpStatus.OK);
				}
			}
			return new ResponseEntity<String>("passwords unmatched", HttpStatus.OK);	
		}
}