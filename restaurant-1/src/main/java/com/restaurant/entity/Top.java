package com.restaurant.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "top")
public class Top {
  private Long tablePK;
  private Long tableId;
  private int seats;
  private int section;
  @OneToMany(mappedBy="top")
  private List<Ticket> tickets = new ArrayList<>();
  
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long getTablePK() {
    return tablePK;
  }
  public void setTablePK(Long tablePK) {
    this.tablePK = tablePK;
  }
  public Long getTableId() {
    return tableId;
  }
  public void setTableId(Long tableId) {
    this.tableId = tableId;
  }
  public int getSeats() {
    return seats;
  }
  public void setSeats(int seats) {
    this.seats = seats;
  }
  public int getSection() {
    return section;
  }
  public void setSection(int section) {
    this.section = section;
  }
}
