package com.exam.examServer.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examServer.models.Question;
import com.exam.examServer.models.Quiz;
import com.exam.examServer.service.QuestionService;
import com.exam.examServer.service.QuizService;

@RestController
@RequestMapping("/questions")
@CrossOrigin("*")
public class QuestionController {
	@Autowired 
	private QuestionService questionService;
	
	@Autowired
	private QuizService quizService;
	
	
	@PostMapping("/")
	public ResponseEntity<?> addNewQuestion(@RequestBody Question question) {
		return ResponseEntity.ok(this.questionService.addQuestion(question));
	}
	
	
	@GetMapping("/{questionId}")
	public ResponseEntity<?> getQuestionById(@PathVariable Long questionId) {
		  Optional<Question> QuestionOptional=this.questionService.getQuestion(questionId);

		    if (QuestionOptional.isPresent()) {
		        Question question = QuestionOptional.get();
		        return ResponseEntity.ok(question);
		    } else {
		        return ResponseEntity.notFound().build();
		    }
	}
	

	
	@GetMapping("/")
	public ResponseEntity<?> getAllQuestions(){
		return ResponseEntity.ok(this.questionService.getQuestions());
	}
	

	@PutMapping("/")
	public ResponseEntity<?> updateQuestion(@RequestBody Question question) {
		return ResponseEntity.ok(this.questionService.updateQuestion(question));
	}
	
	@GetMapping("/quiz/{quizId}")
	public ResponseEntity<?> getQuestionsOfAQuiz(@PathVariable Long quizId){

		Quiz quiz =this.quizService.getQuizById(quizId).get();
		Set<Question> questionSet=quiz.getQuestions();
		List list=new ArrayList<>(questionSet);
		if(list.size()>Integer.parseInt(quiz.getNumberOfQuestions())) {
			list=list.subList(0,Integer.parseInt(quiz.getNumberOfQuestions()));
		}
		Collections.shuffle(list);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/quiz/all/{quizId}")
	public ResponseEntity<?> getQuestionsOfQuizAdmin(@PathVariable Long quizId){

		Quiz quiz =this.quizService.getQuizById(quizId).get();
		Set<Question> questionSet=quiz.getQuestions();
		List list=new ArrayList<>(questionSet);
		Collections.shuffle(list);
		return ResponseEntity.ok(list);
	}
	
	
	@DeleteMapping("/{questionId}")
	public void deleteQuestion(@PathVariable Long questionId) {
		try {
		this.questionService.deleteQuestion(questionId);}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
