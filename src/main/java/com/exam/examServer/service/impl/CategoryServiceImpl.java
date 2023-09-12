package com.exam.examServer.service.impl;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examServer.models.Category;
import com.exam.examServer.repository.CategoryRepository;
import com.exam.examServer.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	

	@Override
	public Category addNewCategory(Category category) {
		
		return this.categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		
		return this.categoryRepository.save(category);
		
	}

	@Override
	public Set<Category> getCategories() {
		
		return new LinkedHashSet<>(this.categoryRepository.findAll());
	}

	@Override
	public Optional<Category> getCategoryById(Long categoryId) {
		
		return this.categoryRepository.findById(categoryId);
	}

	@Override
	public void deleteCategory(Long categoryId) {
		
		categoryRepository.deleteById(categoryId);
	}

	
}
