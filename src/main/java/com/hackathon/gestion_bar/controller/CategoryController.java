package com.hackathon.gestion_bar.controller;

import com.hackathon.gestion_bar.model.Category;
import com.hackathon.gestion_bar.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class CategoryController {
    private CategoryService service;

    @CrossOrigin
    @GetMapping("/categories")
    public List<Category> getAllCategories(@RequestParam(name = "name", required = false)String name){
        if(name != null){
            return service.getCategoryByName(name);
        }else{
            return service.allCategory();
        }
    }

    @CrossOrigin
    @GetMapping("/categories/{id}")
    public Optional<Category> getCategoryById(@PathVariable Long id){
        return service.getCategoryById(id);
    }

    @CrossOrigin
    @PostMapping("/categories")
    public void insertCategory(@RequestBody Category category){
        service.insertCategory(category);
    }

    @CrossOrigin
    @PutMapping("/categories/{id}")
    public void updateCategory(
            @PathVariable(name = "id-category")Long id,
            @RequestParam(name = "new_name")String name
            ){
        service.updateCategory(id, name);
    }

    @CrossOrigin
    @DeleteMapping("/categories/{id}")
    public void deleteId(@PathVariable(name = "id")Long id){
        service.deleteById(id);
    }
}
