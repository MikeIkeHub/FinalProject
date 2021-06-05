package com.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restaurant.entity.Employee;
import com.restaurant.repository.EmployeeRepository;

@Service
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepo;
  
//CREATE - Create Employee
  public Employee addEmployee(Employee employee) {
    return employeeRepo.save(employee);
  }
  
//READ - Return All Employees
  public Iterable<Employee> getEmployees(){
    return employeeRepo.findAll();
  }
  
//UPDATE - Updates an employee
  public Employee updateEmployee(Employee employee, String fullName) throws Exception {
    try {
      Employee needsUpdateEmployee = employeeRepo.findByFullName(fullName);
      needsUpdateEmployee.setFullName(employee.getFullName());
      needsUpdateEmployee.setHourlyPay(employee.getHourlyPay());
      needsUpdateEmployee.setPhoneNumber(employee.getPhoneNumber());
      needsUpdateEmployee.setOccupation(employee.getOccupation());
      return employeeRepo.save(needsUpdateEmployee);
    }catch(Exception e) {
      throw new Exception("Unable to Update Employee");
    }
  }
  
//DELETE
  public void deleteEmployee(Long ID) {
    employeeRepo.deleteById(ID);
  }
}
