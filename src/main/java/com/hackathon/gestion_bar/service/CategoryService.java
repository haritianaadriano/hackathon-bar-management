package com.hackathon.gestion_bar.service;

import com.hackathon.gestion_bar.model.Category;
import com.hackathon.gestion_bar.repository.CategoryRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {
    private CategoryRespository repository;

    public void insertCategory(Category category){
        repository.save(category);
    }

    public List<Category> allCategory(){
        return repository.findAll();
    }

    public List<Category> getCategoryByName(String categoryName){
        return repository.findByNameCategoryContainingIgnoreCase(categoryName);
    }

    public Optional<Category> getCategoryById(Long id){
        return repository.findByIdCategory(id);
    }

    public void updateCategory(Long id, String newCategoryName){
        Optional<Category> category = repository.findByIdCategory(id);

        if(category.isPresent()){
            Category newCategory = category.get();
            newCategory.setNameCategory(newCategoryName);
            repository.save(newCategory);
        }else{
            throw new NullPointerException("sorry you have a problem in:");
        }
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
