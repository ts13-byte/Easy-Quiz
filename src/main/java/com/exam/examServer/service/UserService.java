package com.exam.examServer.service;

import java.util.Set;

import com.exam.examServer.models.Role;
import com.exam.examServer.models.User;
import com.exam.examServer.models.UserRole;

public interface UserService {
	
	//creating user based on the role
	public User createUser(User user, Set<UserRole> userRoles) throws Exception;
	
	

	
}
