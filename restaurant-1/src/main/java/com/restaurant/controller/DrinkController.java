package com.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.restaurant.entity.Drink;
import com.restaurant.service.DrinkService;

@RestController
@RequestMapping("/drinks")
public class DrinkController {
  
  @Autowired
  private DrinkService drinkService;
  
  //CREATE - HTTP POST
  @RequestMapping(value = "/addDrink", method = RequestMethod.POST)
  public ResponseEntity<Object> createDrink(@RequestBody Drink drink){
    try {
      return new ResponseEntity<Object>(drinkService.createDrink(drink), HttpStatus.CREATED);
    }catch(Exception e) {
      return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }
  
  //READ - HTTP GET
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<Object> getDrinks(){
    return new ResponseEntity<Object>(drinkService.getDrinks(), HttpStatus.OK);
  }
  
  //UPDATE - HTTP PUT
  @RequestMapping(value = "/{name}" , method = RequestMethod.PUT)
  public ResponseEntity<Object> updateDrink(@RequestBody Drink drink, @PathVariable String name){
    try {
      return new ResponseEntity<Object>(drinkService.updateDrink(drink, name), HttpStatus.OK);
    }catch(Exception e) {
      return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
  }
  
  //DELETE - HTTP DELETE
  @RequestMapping(value = "/deleteDrink/{PK}", method = RequestMethod.DELETE)
  public ResponseEntity<Object> deleteDrink(@PathVariable Long PK){
    try {
      drinkService.deleteDrink(PK);
      return new ResponseEntity<Object>("Successfully deleted drink", HttpStatus.OK);
    }catch(Exception e) {
      return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
  }
}