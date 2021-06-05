package com.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.restaurant.entity.Schedule;
import com.restaurant.service.ScheduleService;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

  @Autowired
  private ScheduleService scheduleService;
  
  //CREATE - HTTP POST
  @RequestMapping(value = "/addSchedule", method = RequestMethod.POST)
  public ResponseEntity<Object> addSchedule(@RequestBody Schedule schedule){
    try {
      return new ResponseEntity<Object>(scheduleService.addSchedule(schedule), HttpStatus.CREATED);
    }catch(Exception e) {
      return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }
  
  //READ - HTTP GET
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<Object> getSchedules(){
    return new ResponseEntity<Object>(scheduleService.getSchedules(), HttpStatus.OK);
  }
  
  //UPDATE - HTTP PUT
  @RequestMapping(value = "/{Id}", method = RequestMethod.PUT)
  public ResponseEntity<Object> updateSchedule(@RequestBody Schedule schedule, @PathVariable Long Id){
    try {
      return new ResponseEntity<Object>(scheduleService.updateSchedule(schedule, Id), HttpStatus.OK);
    }catch(Exception e) {
      return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
  }
  
  //DELETE - HTTP DELETE
  @RequestMapping(value = "/deleteSchedule/{PK}", method = RequestMethod.DELETE)
  public ResponseEntity<Object> deleteSchedule(@PathVariable Long PK){
    try {
      scheduleService.deleteSchedule(PK);
      return new ResponseEntity<Object>("Successfully removed schedule", HttpStatus.OK);
    }catch(Exception e) {
      return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
  }
}
