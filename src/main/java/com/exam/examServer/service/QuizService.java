package com.exam.examServer.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.exam.examServer.models.Category;
import com.exam.examServer.models.Question;
import com.exam.examServer.models.Quiz;

public interface QuizService {

	public Quiz addNewQuiz(Quiz quiz);
	
	public Quiz updateQuiz(Quiz quiz);
	
	public Set<Quiz> getAllQuizzes();
	
	public Optional<Quiz> getQuizById(Long QuizId);
	
	public void deleteQuizById(Long QuizId);
	
	public Set<Quiz> getQuizzesOfCategory(Category category);	
	
	public List<Quiz> getAllActiveQuizzes();
	
	public List<Quiz> getAllActiveQuizzesOfACategory(Category category);
}
