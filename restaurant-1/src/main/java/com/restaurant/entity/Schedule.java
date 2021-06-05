package com.restaurant.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "schedule")
public class Schedule {
  private Long schedulePK;
  private Long scheduleId;
  private Hour schedule;
  
  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "schedule")
  private List<Employee> employees = new ArrayList<>();
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long getSchedulePK() {
    return schedulePK;
  }
  public void setSchedulePK(Long schedulePK) {
    this.schedulePK = schedulePK;
  }
  public Long getScheduleId() {
    return scheduleId;
  }
  public void setScheduleId(Long scheduleId) {
    this.scheduleId = scheduleId;
  }
  public Hour getSchedule() {
    return schedule;
  }
  public void setSchedule(Hour schedule) {
    this.schedule = schedule;
  }
}