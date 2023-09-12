package com.exam.examServer.models;

import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name="category")
public class Category {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private long cid;

private String title;

private String description;

@OneToMany(mappedBy="category",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
@JsonIgnore
private Set<Quiz> quizzes=new LinkedHashSet<>();

}
