package com.exam.examServer.service.impl;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examServer.models.Category;
import com.exam.examServer.models.Question;
import com.exam.examServer.models.Quiz;
import com.exam.examServer.repository.QuizRepository;
import com.exam.examServer.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	private QuizRepository quizRepository;

	@Override
	public Quiz addNewQuiz(Quiz quiz) {
		
		return this.quizRepository.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		
		return this.quizRepository.save(quiz);
	}

	@Override
	public Set<Quiz> getAllQuizzes() {
		return new LinkedHashSet<>(this.quizRepository.findAll());
	}

	@Override
	public Optional<Quiz> getQuizById(Long QuizId) {
	 return this.quizRepository.findById(QuizId);
	}

	@Override
	public void deleteQuizById(Long QuizId) {
		this.quizRepository.deleteById(QuizId);
	}

	@Override
	public Set<Quiz> getQuizzesOfCategory(Category category) {
		return this.quizRepository.findByCategory(category);
	}
	
}
