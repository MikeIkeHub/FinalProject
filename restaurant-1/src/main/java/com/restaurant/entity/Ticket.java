package com.restaurant.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ticket")
public class Ticket {
  private Long ticketPk;
  private Drink drinkFK;
  private Employee emp;
  private Menu menu;
  private Top table;
  
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @JsonIgnore
  public Long getTicketPk() {
    return ticketPk;
  }
  public void setTicketPk(Long ticketPk) {
    this.ticketPk = ticketPk;
  }
  @ManyToOne
  @JoinColumn(name="drinkpk", nullable=false)
  @JsonIgnore
  public Drink getDrinkFK() {
    return drinkFK;
  }
  public void setDrinkFK(Drink drinkFK) {
    this.drinkFK = drinkFK;
  }
  @ManyToOne
  @JoinColumn(name="emp_id", nullable=false)
  @JsonIgnore
  public Employee getEmp() {
    return emp;
  }
  public void setEmp(Employee emp) {
    this.emp = emp;
  }
  @ManyToOne
  @JoinColumn(name="menupk", nullable=false)
  @JsonIgnore
  public Menu getMenu() {
    return menu;
  }
  public void setMenu(Menu menu) {
    this.menu = menu;
  }
  @ManyToOne
  @JoinColumn(name="tablepk", nullable=false)
  @JsonIgnore
  public Top getTable() {
    return table;
  }
  public void setTable(Top table) {
    this.table = table;
  }


}