package com.exam.examServer.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.exam.examServer.models.Question;
import com.exam.examServer.models.Quiz;

public interface QuestionService {

	public Question addQuestion(Question question);
	
	public Question updateQuestion(Question question);
	
	public Set<Question> getQuestions();
	
	public Optional<Question> getQuestion(Long quesId);
	
	public Set<Question> getQuestionsOfQuiz(Quiz quiz);
	
	public void deleteQuestion(Long questionId);
	
	public List<Question> getRequestedNumberOfQuestions(Long quizId);
	
	public Question get(Long questionId);
	
}
