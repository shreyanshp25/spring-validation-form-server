package com.Authentication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Authentication.Models.Users;
import com.Authentication.Repository.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;
	
	//register a user
	public Users registerUser(Users user) {
		return userRepo.save(user);
	}
	//check if a user already exists
	public Users findByemai(String email) {
		return userRepo.findByemailId(email);
	}
	//fetch by email and password
	public Users findByEmailAndPass(String email, String pass) {
		return userRepo.findByemailIdAndPassword(email, pass);
	}
}
