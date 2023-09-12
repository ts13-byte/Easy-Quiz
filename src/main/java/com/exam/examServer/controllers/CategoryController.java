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
import com.exam.examServer.service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

	@Autowired 
	private CategoryService categoryService;
	
	/**
	 * Adds  new category of quizzes in the exam portal
	 * @param category
	 * @return returns a new category object with response code 200
	 */
	@PostMapping("/")
	public ResponseEntity<?> addNewCategory(@RequestBody Category category) {
		Category category1=this.categoryService.addNewCategory(category);
		return ResponseEntity.ok(category1);
	}
	
	/**
	 * Gets the category based on the category ID
	 * @param categoryId
	 * @return returns a single category object
	 */
	@GetMapping("/{categoryId}")
	public ResponseEntity<?> getCategory(@PathVariable Long categoryId) {
		  Optional<Category> categoryOptional = this.categoryService.getCategoryById(categoryId);

		    if (categoryOptional.isPresent()) {
		        Category category = categoryOptional.get();
		        return ResponseEntity.ok(category);
		    } else {
		        return ResponseEntity.notFound().build();
		    }
	}
	
	/**
	 * Gets all the categories in the exam portal present
	 * @return returns a set of categories
	 */
	
	@GetMapping("/")
	public ResponseEntity<?> getAllCategories(){
		return ResponseEntity.ok(this.categoryService.getCategories());
	}
	
	/**
	 * Takes the earlier category and updates it
	 * @param category
	 * @return returns the updated category object
	 */
	@PutMapping("/")
	public Category updateCategory(@RequestBody Category category) {
		return this.categoryService.updateCategory(category);
		
	}
	
	/**
	 * deletes a category based on the categoryId
	 * @param categoryId
	 */
	@DeleteMapping("/{categoryId}")
	public void deleteCategory(@PathVariable Long categoryId) {
		this.categoryService.deleteCategory(categoryId);
	}
	
	
}
