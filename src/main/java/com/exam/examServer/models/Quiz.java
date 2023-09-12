package com.exam.examServer.models;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class Quiz {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long qid;
	
	private String title;
	
	private String description;
	
	private String maxMarks;
	
	private String numberOfQuestions;
	
	private boolean active=false;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Category category;
	
	@OneToMany(mappedBy="quiz",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<Question> questions=new HashSet<>();
}
