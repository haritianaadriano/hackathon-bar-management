package com.hackathon.gestion_bar.service;

import com.hackathon.gestion_bar.model.Cocktail;
import com.hackathon.gestion_bar.model.Compose;
import com.hackathon.gestion_bar.model.ComposeParameter;
import com.hackathon.gestion_bar.model.ParameterPostCoclail;
import com.hackathon.gestion_bar.repository.CocktailRepository;
import com.hackathon.gestion_bar.repository.ComposeRepository;
import com.hackathon.gestion_bar.repository.DrinkRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CocktailService {
    private CocktailRepository repositoryCocktail;

    private DrinkRepository repositoryDrink;

    private ComposeRepository repositoryCompose;

    public void insertCocktail(ParameterPostCoclail cocktail) {
        Cocktail newCoctail = new Cocktail();
        newCoctail.setNameCocktail(cocktail.getNameCocktail());
        repositoryCocktail.save(newCoctail);
        for (ComposeParameter x : cocktail.getCompose()) {
            Compose newCompose = new Compose();
            newCompose.setCocktail(repositoryCocktail.getById(newCoctail.getIdCocktail()));
            newCompose.setDrink(repositoryDrink.getById(x.getIdDrink()));
            repositoryCompose.save(newCompose);
        }
        ;
        Compose newCompose = new Compose();
    }

    public void deleteCocktail(Long id) {
        Compose composeToDelete = new Compose();
        Long idCocktailToDelete = composeToDelete.getCocktail().getIdCocktail();
        if (idCocktailToDelete == id) {
            repositoryCocktail.deleteById(idCocktailToDelete);
            repositoryCompose.deleteById(composeToDelete.getIdCompose());
        }
    }

    public List<Compose> getAllCompose() {
        return repositoryCompose.findAll();
    }

    public List<Compose> getComposeById(Long id){
        return repositoryCompose.findAllByCocktailIdCocktail(id);
    }
}
