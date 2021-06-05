package com.restaurant.repository;

import org.springframework.data.repository.CrudRepository;
import com.restaurant.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

  public Employee findByFullName(String fullName);
}
