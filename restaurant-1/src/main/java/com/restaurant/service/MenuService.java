package com.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restaurant.entity.Menu;
import com.restaurant.repository.MenuRepository;

@Service
public class MenuService {

  @Autowired
  private MenuRepository menuRepo;
  
//CREATE - Create Menu
  public Menu addMenu(Menu menu) {
    return menuRepo.save(menu);
  }
  
//READ - Return All Food Items
  public Iterable<Menu> getMenu(){
    return menuRepo.findAll();
  }
  
//UPDATE - Update Food Item
  public Menu updateMenu(Menu menu, String foodName) throws Exception {
    try {
      Menu needsUpdateMenu = menuRepo.findByFoodName(foodName);
      needsUpdateMenu.setFoodName(menu.getFoodName());
      needsUpdateMenu.setPrice(menu.getPrice());
      return menuRepo.save(needsUpdateMenu);
    }catch(Exception e) {
      throw new Exception("Unable to Update Menu");
    }
  }
  
//DELETE
  public void deleteMenu(Long PK) {
    menuRepo.deleteById(PK);
  }
}
