package com.exam.examServer.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examServer.config.JwtUtil;
import com.exam.examServer.exceptions.UserNotFoundException;
import com.exam.examServer.models.JwtRequest;
import com.exam.examServer.models.JwtResponse;
import com.exam.examServer.models.User;
import com.exam.examServer.service.impl.UserDetailServiceImpl;

@RestController
@CrossOrigin("*")
public class AuthenticateController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;

	@Autowired
	private JwtUtil jwtUtil;
	
	/**
	 * This API generates a JWT Authentication token that will help in access other APIs.
	 * @param jwtRequest
	 * @return
	 * @throws Exception
	 */

	@PostMapping("/generate-token")
	public ResponseEntity<JwtResponse> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		try {
			
			authenticate(jwtRequest.getUserName(), jwtRequest.getPassword());
			
		} catch (UserNotFoundException e) {
			e.printStackTrace();
			throw new Exception("User not found");
		}
		UserDetails userDetails = this.userDetailServiceImpl.loadUserByUsername(jwtRequest.getUserName());
		String token = this.jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String userName, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
		} catch (DisabledException e) {
			throw new Exception("This user is disabled: " + e.getMessage());
		} catch (BadCredentialsException e) {
			throw new Exception("Invalid credentials: " + e.getMessage());
		}catch (Exception e) {
	        e.printStackTrace(); // Add this line to print the full stack trace
	        throw new Exception("Authentication error: " + e.getMessage());
	    }
	}
	/**
	 * This API returns the currently logged in user 
	 * @param principal
	 * @return
	 */
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal) {
		return (User) this.userDetailServiceImpl.loadUserByUsername(principal.getName());
	}
}
