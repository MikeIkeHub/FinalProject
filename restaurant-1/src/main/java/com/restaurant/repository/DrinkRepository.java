package com.restaurant.repository;

import org.springframework.data.repository.CrudRepository;
import com.restaurant.entity.Drink;

public interface DrinkRepository extends CrudRepository<Drink, Long> {
  
  public Drink findByDrinkName(String drinkName);
}
