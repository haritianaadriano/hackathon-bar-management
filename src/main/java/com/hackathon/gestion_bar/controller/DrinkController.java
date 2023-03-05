package com.hackathon.gestion_bar.controller;

import com.hackathon.gestion_bar.model.Drink;
import com.hackathon.gestion_bar.service.DrinkService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class DrinkController {
    private DrinkService service;

    @CrossOrigin
    @GetMapping("/drinks")
    public Page<Drink> getAllDrink(
            @RequestParam(name = "page")int page,
            @RequestParam(name = "page_size")int pageSize
    ){
        return service.getAllDrink(page, pageSize);
    }

    @CrossOrigin
    @GetMapping("/drink")
    public List<Drink> getSpecific(
            @RequestParam(name = "page", required = false)int page,
            @RequestParam(name = "page_size", required = false)int pageSize,
            @RequestParam(name = "name", required = false)String name,
            @RequestParam(name = "price_above", required = false)Double priceAbove,
            @RequestParam(name = "price_under", required = false)Double priceUnder
    ){
        if(name != null) {
            Pageable pageRequest = PageRequest.of(page, pageSize);
            return service.getDrinkByName(name, pageRequest);
        }else {
            return service.getDrinkAboveOrUnder(priceUnder, priceAbove);
        }
    }

    @CrossOrigin
    @GetMapping("/drinks/{id}")
    public Optional<Drink> getDrinkById(@PathVariable Long id){
        return service.getDrinkById(id);
    }

    @CrossOrigin
    @GetMapping("/categories/{id_category}/drinks")
    public  List<Drink> getDrinkByCategoryId(@PathVariable(name = "id_category") Long id){
        return service.drinkFilterByCategory(id);
    }

    @CrossOrigin
    @PostMapping("/drinks")
    public void insertDrink(@RequestBody Drink drink){
        service.insertDrink(drink);
    }

    @CrossOrigin
    @PatchMapping("/drinks")
    public void updateDrink(
            @RequestParam(name = "id")Long id,
            @RequestParam(name = "new_Name")String newName,
            @RequestParam(name = "new_Price")Double price
    ){
        service.updateDrink(id, newName, price);
    }

    @CrossOrigin
    @DeleteMapping("/drinks/{id}")
    public void deleteDrink(@PathVariable(name = "id")Long id){
        service.deleteDrinkById(id);
    }
}
