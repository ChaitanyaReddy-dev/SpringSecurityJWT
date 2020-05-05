package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.AuthenticationRequest;
import com.example.model.AuthenticationResponse;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.utility.JwtUtil;
import com.example.utility.MyUserService;

@RestController
public class SecurityGaurd {
	
	@Autowired
	MyUserService myUserService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	JwtUtil jwtUtil;
	
	
	
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@GetMapping("details")
	public String display() {
		return "<h1>Welcome Back <h1>";
	}
	@GetMapping("admin")
	public String admin() {
		return "<h1>Welcome Back Admin<h1>";
	}
	@GetMapping("user")
	public String user() {
		return "<h1>Welcome Back user<h1>";
	}
	
	@PostMapping("/authenticate")
	public String createWebToken(@RequestBody AuthenticationRequest request){
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
		}
		catch(BadCredentialsException e) {
			System.out.println("invalid credentials");
		}
		
		//User user=userRepository.findByUserName(request.getUserName());
		final UserDetails userdetails=myUserService.loadUserByUsername(request.getUserName());
		
		String jwtToken=jwtUtil.generateToken(userdetails.getUsername());
		System.out.println(jwtToken);
		return jwtToken;
		
	}
	
	
}
