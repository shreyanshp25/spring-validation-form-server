package com.Authentication.Controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Authentication.Models.Users;
import com.Authentication.Service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	@Autowired
	private UserService userService;
	//register a user
	@PostMapping("/register")
	public Users registerUser(@RequestBody Users user) throws Exception {
		String email = user.getEmailId();
		if(email != null && !" ".equals(email)) {
			Users obj = userService.findByemai(email);
			if(obj != null) {
				throw new Exception("User with email id "+email+" already exists");
			}
		}
		return userService.registerUser(user);
	}
	//login user
	@PostMapping("/login")
	public Users loginUser(@RequestBody Users user) throws Exception {
		String email = user.getEmailId();
		String pass = user.getPassword();
		Users obj = null;
		if(email != null && pass != null) {
			obj = userService.findByEmailAndPass(email, pass);
		}
		if(obj == null) {
			throw new Exception("bad credentials");
		}
		return obj;
	}
}
