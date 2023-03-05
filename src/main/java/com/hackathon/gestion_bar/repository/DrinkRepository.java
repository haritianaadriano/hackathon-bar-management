package com.hackathon.gestion_bar.repository;

import com.hackathon.gestion_bar.model.Drink;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long> {
    Optional<Drink> findByIdDrink(Long id);

    List<Drink> findByNameDrinkContainingIgnoreCase(String name, Pageable pageable);
}
