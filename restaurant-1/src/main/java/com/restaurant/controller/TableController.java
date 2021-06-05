package com.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.restaurant.entity.Top;
import com.restaurant.service.TableService;

@RestController
@RequestMapping("/tables")
public class TableController {

  @Autowired
  private TableService tableService;
  
  //CREATE - HTTP POST
  @RequestMapping(value = "/addTable", method = RequestMethod.POST)
  public ResponseEntity<Object> addTable(@RequestBody Top table){
    try {
      return new ResponseEntity<Object>(tableService.addTable(table), HttpStatus.CREATED);
    }catch(Exception e) {
      return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }
  
  //READ - HTTP GET
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<Object> getTables(){
    return new ResponseEntity<Object>(tableService.getTables(), HttpStatus.OK);
  }
  
  //UPDATE - HTTP PUT
  @RequestMapping(value = "/{tableId}", method = RequestMethod.PUT)
  public ResponseEntity<Object> updateTable(@RequestBody Top table, @PathVariable Long tableId){
    try {
      return new ResponseEntity<Object>(tableService.updateTable(table, tableId), HttpStatus.OK);
    }catch(Exception e) {
      return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
  }
  
  //DELETE - HTTP DELETE
  @RequestMapping(value = "/deleteTable/{PK}", method = RequestMethod.DELETE)
  public ResponseEntity<Object> deleteSchedule(@PathVariable Long PK){
    try {
      tableService.deleteTable(PK);
      return new ResponseEntity<Object>("Successfully removed table", HttpStatus.OK);
    }catch(Exception e) {
      return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
  }
}
