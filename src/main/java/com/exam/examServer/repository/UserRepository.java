package com.exam.examServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.examServer.models.User;

public interface UserRepository extends JpaRepository<User,Long> {

	public User findByUserName(String userName);
	
	

}
