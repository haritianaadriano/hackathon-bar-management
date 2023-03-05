package com.hackathon.gestion_bar.repository;

import com.hackathon.gestion_bar.model.Compose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComposeRepository extends JpaRepository<Compose, Long> {
    List<Compose> findAllByCocktailIdCocktail(Long id);
}
