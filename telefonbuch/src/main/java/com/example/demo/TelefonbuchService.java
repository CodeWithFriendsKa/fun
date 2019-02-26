package com.example.demo;

import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelefonbuchService {
	
	@Autowired
	private PersonCRUDRepository personRepo;
	@Autowired
	private UserCRUDRepository userRepo;

	//Find All
	public ArrayList<Person> getAllPersons(){
		ArrayList<Person> list = new ArrayList<Person>();
		personRepo.findAll().forEach(list::add);
		return list;
	}
	//Create
	public void createPerson(Person p) {
		personRepo.save(p);
	}
	//DeleteAll
	public void deleteAll() {
		personRepo.deleteAll();
	}
	
	
	
	
	
	//Find User By Id or return null
	public Optional<User> findUser(String username) {
		try {
			return userRepo.findById(username);
		}
		catch(Exception ex) {
			return null;
		}
	}
	//Create new User
	public void createUser(User user) {
		userRepo.save(user);
	}
	/**
	public boolean userAuthentification(HttpSession session) {
		try {
			User user = new User(session.getAttribute("user"));
			if(user.getUsername().equals("Tamino") && user.getPassword().equals("123") && ((user.getToken() + 60000) > System.currentTimeMillis())) {
				return true;
			}
			else return false;
		}
		catch(Exception ex) {
			return false;
		}
	}**/
	public boolean userAuthentification(HttpSession session) {
		try {
			User sessionUser = new User(session.getAttribute("user"));
			User dbUser = findUser(sessionUser.getUsername()).get();
			if(sessionUser.getUsername().equals(dbUser.getUsername()) && sessionUser.getPassword().equals(dbUser.getPassword())) {
				if((sessionUser.getToken() + 60000) > System.currentTimeMillis()) {
					return true;
				}else return false;
			}
			else return false;
		}
		catch(Exception ex) {
			return false;
		}
	}
}

