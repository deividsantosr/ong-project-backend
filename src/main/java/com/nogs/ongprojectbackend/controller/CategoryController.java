package com.nogs.ongprojectbackend.controller;

import com.nogs.ongprojectbackend.model.dao.Category;
import com.nogs.ongprojectbackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    @Autowired
    CategoryService firebaseService;

    @GetMapping
    public Category getCategory(@RequestParam String id) throws InterruptedException, ExecutionException {
        return firebaseService.getCategoryDetails(id);
    }

    @GetMapping("/list")
    public List<Category> getCategorys() throws InterruptedException, ExecutionException {
        return firebaseService.getCategoryDetails();
    }

    @PostMapping
    public String createCategory(@RequestBody Category category) throws InterruptedException, ExecutionException {
        return firebaseService.saveCategoryDetails(category);
    }

    @PutMapping
    public String updateCategory(@RequestBody Category category) throws InterruptedException, ExecutionException {
        return firebaseService.updateCategoryDetails(category);
    }

    @DeleteMapping
    public String deleteCategory(@RequestParam String id) {
        return firebaseService.deleteCategory(id);
    }
}