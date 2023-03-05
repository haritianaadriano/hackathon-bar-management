package com.hackathon.gestion_bar.service;

import com.hackathon.gestion_bar.model.Drink;
import com.hackathon.gestion_bar.model.User;
import com.hackathon.gestion_bar.repository.DrinkRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DrinkService {
    private DrinkRepository repository;

    public Page<Drink> getAllDrink(int numberPage, int pageSize){
        return repository.findAll(PageRequest.of(numberPage, pageSize));
    }

    public void insertDrink(Drink drink){
        repository.save(drink);
    }

    public List<Drink> getDrinkByName(String nameDrink, Pageable pageable){
        if(nameDrink != null){
            return repository.findByNameDrinkContainingIgnoreCase(nameDrink, pageable);
        }else {
            return null;
        }
    }

    public Optional<Drink> getDrinkById(Long id){
        return repository.findByIdDrink(id);
    }

    public List<Drink> getUnderDrink(Double under){
        List<Drink> drinks = repository.findAll();
        List<Drink> underDrink = new ArrayList<>();

         for(int i=0; i<drinks.size(); i++) {
             if (drinks.get(i).getPriceDrink() <= under) {
                 underDrink.add(drinks.get(i));
             }
         }
         if(under != null){
             return underDrink;
         }else{
             return null;
         }
    }

    public List<Drink> getAboveDrink(Double above) {
        List<Drink> drinks = repository.findAll();
        List<Drink> aboveDrink = new ArrayList<>();

        for (int i = 0; i < drinks.size(); i++) {
            if (drinks.get(i).getPriceDrink() >= above) {
                aboveDrink.add(drinks.get(i));
            }
        }
        if(above != null){
            return aboveDrink;
        }else{
            return null;
        }
    }

    public List<Drink> getDrinkAboveOrUnder(Double priceUnder, Double priceAbove){
        if(priceAbove != null){
            return this.getAboveDrink(priceAbove);
        }else if(priceUnder != null){
            return  this.getUnderDrink(priceUnder);
        }else return null;
    }

    public void updateDrink(Long id, String newDrink, Double newPrice){
        Optional<Drink> drinks = repository.findByIdDrink(id);

        if(drinks.isPresent()){
            Drink drink = drinks.get();
            drink.setNameDrink(newDrink);
            drink.setPriceDrink(newPrice);
            repository.save(drink);
        }else{
            throw new NullPointerException("Drink not found");
        }
    }

    public List<Drink> drinkFilterByCategory(Long id){
        List<Drink> drinks = repository.findAll();
        List<Drink> drinksFiltered = new ArrayList<>();

        for(int z=0; z<drinks.size(); z++){
            if(drinks.get(z).getCategory().getIdCategory() == id){
                drinksFiltered.add(drinks.get(z));
            }
        }
        return drinksFiltered;
    }

    public void deleteDrinkById(Long id){
        repository.deleteById(id);
    }
}
