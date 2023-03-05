package com.hackathon.gestion_bar.repository;

import com.hackathon.gestion_bar.model.Cocktail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CocktailRepository extends JpaRepository<Cocktail, Long> {
    Optional<Cocktail> findByIdCocktail(Long id);
    List<Cocktail> findByNameCocktailContainingIgnoreCase(String nameCocktail);

}
