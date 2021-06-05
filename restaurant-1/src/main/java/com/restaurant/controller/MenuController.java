package com.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.restaurant.entity.Menu;
import com.restaurant.service.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {

  @Autowired
  private MenuService menuService;
  
  //CREATE - HTTP POST
  @RequestMapping(value = "/addMenu", method = RequestMethod.POST)
  public ResponseEntity<Object> addMenu(@RequestBody Menu menu){
    try {
      return new ResponseEntity<Object>(menuService.addMenu(menu), HttpStatus.CREATED);
    }catch(Exception e) {
      return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }
  
  //READ - HTTP GET
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<Object> getMenu(){
    return new ResponseEntity<Object>(menuService.getMenu(), HttpStatus.OK);
  }
  
  //UPDATE - HTTP PUT
  @RequestMapping(value = "/{foodName}", method = RequestMethod.PUT)
  public ResponseEntity<Object> updateMenu(@RequestBody Menu menu, @PathVariable String foodName){
    try {
      return new ResponseEntity<Object>(menuService.updateMenu(menu, foodName), HttpStatus.OK);
    }catch(Exception e){
      return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
  }
  
  //DELETE - HTTP DELETE
  @RequestMapping(value = "/deleteMenu/{PK}", method = RequestMethod.DELETE)
  public ResponseEntity<Object> deleteMenu(@PathVariable Long PK){
    try {
      menuService.deleteMenu(PK);
      return new ResponseEntity<Object>("Successfully removed food item", HttpStatus.OK);
    }catch(Exception e) {
      return new ResponseEntity<Object>(e.getMessage(),HttpStatus.NOT_FOUND);
    }
  }
  
}
