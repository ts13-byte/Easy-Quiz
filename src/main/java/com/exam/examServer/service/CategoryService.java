package com.exam.examServer.service;

import java.util.Optional;
import java.util.Set;

import com.exam.examServer.models.Category;

public interface CategoryService {
	
 public Category addNewCategory(Category category);
 
 public Category updateCategory(Category category);
 
 public Set<Category> getCategories();
 
 public Optional<Category> getCategoryById(Long categoryId);
 
 public void deleteCategory(Long categoryId);
 
}
