package com.exam.examServer.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.examServer.models.Question;
import com.exam.examServer.models.Quiz;

public interface  QuestionRepository extends JpaRepository<Question,Long>{

	Set<Question> findByQuiz(Quiz quiz);
	

}
