package com.exam.examServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.examServer.models.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

}
