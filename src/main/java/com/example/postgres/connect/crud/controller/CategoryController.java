package com.example.postgres.connect.crud.controller;

import com.example.postgres.connect.crud.exception.ResourceNotFoundException;
import com.example.postgres.connect.crud.model.Category;
import com.example.postgres.connect.crud.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category_management")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/category")
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable(value = "id") Integer categoryId)
        throws ResourceNotFoundException {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found for this id : " + categoryId));
        return ResponseEntity.ok().body(category);
    }

    @PostMapping("/category")
    public Category createCategory(@RequestBody Category category) {

        return categoryRepository.save(category);
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable(value = "id") Integer categoryId,
                                   @RequestBody Category categoryDetails) throws ResourceNotFoundException {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + categoryId));

        category.setNameCategory(categoryDetails.getNameCategory());
        final Category updatedCategory = categoryRepository.save(category);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable(name = "id") Integer categoryId) {
        categoryRepository.deleteById(categoryId);
    }

}
