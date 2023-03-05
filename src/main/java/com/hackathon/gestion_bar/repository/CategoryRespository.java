package com.hackathon.gestion_bar.repository;

import com.hackathon.gestion_bar.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRespository extends JpaRepository<Category, Long> {
    Optional<Category> findByIdCategory(Long aLong);

    List<Category> findByNameCategoryContainingIgnoreCase(String categoryName);
}
