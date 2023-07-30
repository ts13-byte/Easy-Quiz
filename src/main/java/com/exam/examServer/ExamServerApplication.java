package com.exam.examServer;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.exam.examServer.exceptions.UserPresentException;
import com.exam.examServer.models.Role;
import com.exam.examServer.models.User;
import com.exam.examServer.models.UserRole;
import com.exam.examServer.service.UserService;

@SpringBootApplication
public class ExamServerApplication{
	
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ExamServerApplication.class, args);
//		String plainPassword = "user123";
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String hashedPassword = passwordEncoder.encode(plainPassword);
//        System.out.println("Hashed Password: " + hashedPassword);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("running code");
//		User user1=new User();
//		user1.setFirstName("Sara");
//		user1.setLastName("Tripathi");
//		user1.setEmail("abc@gmail.com");
//		user1.setEnabled(true);
//		user1.setPhone("1234");
//		user1.setUserName("sara1");
//		user1.setPassword("123");
//		user1.setImage("default.png");
//		
//		Role role1=new Role();
//		role1.setRoleId(44L);
//		role1.setRoleName("admin");
//		
//		Set<UserRole> userRoleSet=new HashSet<>();
//		UserRole userRole=new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user1);
//		userRoleSet.add(userRole);
//		user1=this.userService.createUser(user1, userRoleSet);
//		System.out.println(user1.getUserName());
//	}

}
