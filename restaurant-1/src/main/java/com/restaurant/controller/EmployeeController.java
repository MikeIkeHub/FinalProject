package com.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.restaurant.entity.Employee;
import com.restaurant.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;
  
  //CREATE - HTTP POST
  @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
  public ResponseEntity<Object> addEmployee(@RequestBody Employee employee){
    try {
      return new ResponseEntity<Object>(employeeService.addEmployee(employee), HttpStatus.CREATED);
    }catch(Exception e) {
      return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }
  
  //READ - HTTP GET
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<Object> getEmployees(){
    return new ResponseEntity<Object>(employeeService.getEmployees(), HttpStatus.OK);
  }
  
  //UPDATE - HTTP PUT
  @RequestMapping(value = "/{name}", method = RequestMethod.PUT)
  public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee, @PathVariable String name){
    try {
      return new ResponseEntity<Object>(employeeService.updateEmployee(employee, name), HttpStatus.OK);
    }catch(Exception e) {
      return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
  }
  
  //DELETE - HTTP DELETE
  @RequestMapping(value = "/deleteEmployee/{ID}", method = RequestMethod.DELETE)
  public ResponseEntity<Object> deleteEmployee(@PathVariable Long ID){
    try {
      employeeService.deleteEmployee(ID);
      return new ResponseEntity<Object>("Successfully removed employee", HttpStatus.OK);
    }catch(Exception e) {
      return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
  }
  
}
