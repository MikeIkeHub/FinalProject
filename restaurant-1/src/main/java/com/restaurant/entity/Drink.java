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
@Table(name = "drink")
public class Drink {

  private Long drinkPK;
  private String drinkName;
  private BigDecimal price;
  @OneToMany(mappedBy="drink")
  private List<Ticket> tickets = new ArrayList<>();
  
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long getDrinkPK() {
    return drinkPK;
  }
  public void setDrinkPK(Long drinkPK) {
    this.drinkPK = drinkPK;
  }
  public String getDrinkName() {
    return drinkName;
  }
  public void setDrinkName(String drinkName) {
    this.drinkName = drinkName;
  }
  public BigDecimal getPrice() {
    return price;
  }
  public void setPrice(BigDecimal price) {
    this.price = price;
  }
}
