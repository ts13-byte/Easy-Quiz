package com.exam.examServer.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Question {
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)	
private long quesid;

@Column(length=5000)
private String content;

private String image;

private String option1;

private String option2;

private String option3;

private String option4;


private String answer;

@Transient
private String enteredAnswer;

@ManyToOne(fetch=FetchType.LAZY)
private Quiz quiz;



}
