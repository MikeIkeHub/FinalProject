package com.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restaurant.entity.Drink;
import com.restaurant.repository.DrinkRepository;

@Service
public class DrinkService {

  @Autowired
  private DrinkRepository drinkRepo;
  
//CREATE
  public Drink createDrink(Drink drink) {
    return drinkRepo.save(drink);
  }
  
//READ - RETURN ALL DRINKS
  public Iterable<Drink> getDrinks(){
    return drinkRepo.findAll();
  }
  
//READ - RETURN BY NAME  
  public Drink findByName(String drinkName) {
    return drinkRepo.findByDrinkName(drinkName);
  }
  
//UPDATE
  public Drink updateDrink(Drink drink, String drinkName) throws Exception {
    try {
      Drink needsUpdateDrink = drinkRepo.findByDrinkName(drinkName); // null if nothing is returned
      needsUpdateDrink.setDrinkName(drink.getDrinkName());
      needsUpdateDrink.setPrice(drink.getPrice());
      return drinkRepo.save(needsUpdateDrink);
    }catch(Exception e) {
      throw new Exception("Unable to Update Drink");
    }
    
  }
  
//DELETE
  public void deleteDrink(Long PK) {
    drinkRepo.deleteById(PK);
  }
  
}