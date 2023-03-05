package com.hackathon.gestion_bar.controller;

import com.hackathon.gestion_bar.model.Cocktail;
import com.hackathon.gestion_bar.model.ParameterPostCoclail;
import com.hackathon.gestion_bar.service.CocktailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CocktailController {
    private CocktailService service;

    @CrossOrigin
    @PostMapping("/cocktails")
    public void insertCocktails(@RequestBody ParameterPostCoclail cocktail){
        service.insertCocktail(cocktail);
    }
}
