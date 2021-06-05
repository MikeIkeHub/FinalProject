package com.restaurant.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
  private Long empId;
  private String fullName;
  private Long phoneNumber;
  private Occupation occupation;
  private BigDecimal hourlyPay;
  
  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinTable(name = "employee_schedules")
  private List<Schedule> schedules = new ArrayList<>();
  
  @OneToMany(mappedBy="employee")
  private List<Ticket> tickets = new ArrayList<>();
  
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long getEmpId() {
    return empId;
  }
  public void setEmpId(Long empId) {
    this.empId = empId;
  }
  public String getFullName() {
    return fullName;
  }
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }
  public Long getPhoneNumber() {
    return phoneNumber;
  }
  public void setPhoneNumber(Long phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
  public Occupation getOccupation() {
    return occupation;
  }
  public void setOccupation(Occupation occupation) {
    this.occupation = occupation;
  }
  public BigDecimal getHourlyPay() {
    return hourlyPay;
  }
  public void setHourlyPay(BigDecimal hourlyPay) {
    this.hourlyPay = hourlyPay;
  }
}