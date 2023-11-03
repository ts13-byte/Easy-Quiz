package com.exam.examServer.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.examServer.models.Category;
import com.exam.examServer.models.Question;
import com.exam.examServer.models.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
	Set<Quiz> findByCategory(Category category);
	
	public List<Quiz> findByActive(Boolean b);
	
	public List<Quiz> findByCategoryAndActive(Category category, Boolean b);
}
