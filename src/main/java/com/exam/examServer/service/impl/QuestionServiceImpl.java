package com.exam.examServer.service.impl;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.exam.examServer.models.Question;
import com.exam.examServer.models.Quiz;
import com.exam.examServer.repository.QuestionRepository;
import com.exam.examServer.service.QuestionService;

import jakarta.transaction.Transactional;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Override
	public Question addQuestion(Question question) {
		return this.questionRepository.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		return this.questionRepository.save(question);
	}

	@Override
	public Set<Question> getQuestions() {
		return new LinkedHashSet<>( this.questionRepository.findAll());
	}

	@Override
	public Optional<Question> getQuestion(Long quesId) {
		return this.questionRepository.findById(quesId);
	}

	@Override
	public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
		
		return this.questionRepository.findByQuiz(quiz);
	}

	@Override
	public void deleteQuestion(Long questionId) {
//		  Question question=new Question();
//		  question.setQuesid(questionId);
//		  this.questionRepository.delete(question);
		this.questionRepository.deleteById(questionId);
	}
	
	
	

}
