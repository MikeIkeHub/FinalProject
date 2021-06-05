package com.restaurant.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu {
  private Long menuPK;
  private String foodName;
  private BigDecimal price;
  @OneToMany(mappedBy="menu")
  private List<Ticket> tickets = new ArrayList<>();
  
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long getMenuPK() {
    return menuPK;
  }
  public void setMenuPK(Long menuPK) {
    this.menuPK = menuPK;
  }
  public String getFoodName() {
    return foodName;
  }
  public void setFoodName(String foodName) {
    this.foodName = foodName;
  }
  public BigDecimal getPrice() {
    return price;
  }
  public void setPrice(BigDecimal price) {
    this.price = price;
  }
}