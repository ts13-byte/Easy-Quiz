package com.exam.examServer.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.exam.examServer.models.User;
import com.exam.examServer.models.UserRole;
import com.exam.examServer.repository.RoleRepository;
import com.exam.examServer.repository.UserRepository;
import com.exam.examServer.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	/**
	 * This method looks into database if user is already present or not if not it
	 * creates a new user
	 * 
	 * @throws Exception
	 */
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		User local = this.userRepository.findByUserName(user.getUsername());
		if (local != null) {
			System.out.println("User is already present!");
			throw new Exception("This user is already present!!!");
		} else {
			for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			String rawPassword = user.getPassword();

			// Hash the password using BCryptPasswordEncoder
			String hashedPassword = bCryptPasswordEncoder.encode(rawPassword);

			// Set the hashed password back to the user object
			user.setPassword(hashedPassword);
			local = this.userRepository.save(user);
		}
		return local;

	}

	@Override
	public User getUserByName(String userName) {
		return this.userRepository.findByUserName(userName);
	}

	@Override
	public void DeleteUserById(Long id) {
		this.userRepository.deleteById(id);

	}

}
