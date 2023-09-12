package com.exam.examServer.controllers;

import java.util.Optional;

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

import com.exam.examServer.models.Category;
import com.exam.examServer.models.Quiz;
import com.exam.examServer.service.QuizService;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

	@Autowired 
	private QuizService quizService;
	
	
	@PostMapping("/")
	public ResponseEntity<?> addNewQuiz(@RequestBody Quiz quiz) {
		return ResponseEntity.ok(this.quizService.addNewQuiz(quiz));
	}
	
	
	@GetMapping("/{quizId}")
	public ResponseEntity<?> getQuizById(@PathVariable Long quizId) {
		  Optional<Quiz> QuizOptional=this.quizService.getQuizById(quizId);

		    if (QuizOptional.isPresent()) {
		        Quiz quiz = QuizOptional.get();
		        return ResponseEntity.ok(quiz);
		    } else {
		        return ResponseEntity.notFound().build();
		    }
	}
	

	
	@GetMapping("/")
	public ResponseEntity<?> getAllQuizzes(){
		return ResponseEntity.ok(this.quizService.getAllQuizzes());
	}
	

	@PutMapping("/")
	public ResponseEntity<?> updateQuiz(@RequestBody Quiz quiz) {
		return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
	}
	

	@DeleteMapping("/{quizId}")
	public void deleteQuiz(@PathVariable Long quizId) {
		this.quizService.deleteQuizById(quizId);
	}
}
