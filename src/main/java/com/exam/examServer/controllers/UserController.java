package com.exam.examServer.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examServer.models.User;
import com.exam.examServer.exceptions.UserPresentException;
import com.exam.examServer.models.Role;
import com.exam.examServer.models.UserRole;
import com.exam.examServer.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * This API will handle creating a new user each user will be automatically
	 * assigned a normal user role
	 * 
	 * @param user
	 * @return user
	 * @throws Exception
	 */
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {

		UserRole userRole = new UserRole();
		Set<UserRole> userRolesSet = new HashSet<>();

		Role role = new Role();
		role.setRoleId(45L);
		role.setRoleName("Normal");

		userRole.setRole(role);
		userRole.setUser(user);
		userRolesSet.add(userRole);
		return this.userService.createUser(user, userRolesSet);

	}

	/**
	 * This GET API returns User based upon the userName from the database.
	 * 
	 * @param userName
	 * @return User
	 */
	@GetMapping("/{userName}")
	public User getUser(@PathVariable String userName) {

		return userService.getUserByName(userName);
	}

	/**
	 * This API is to delete a user based upon it's Id
	 * 
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void DeleteUser(@PathVariable Long id) {

		userService.DeleteUserById(id);
	}
}
