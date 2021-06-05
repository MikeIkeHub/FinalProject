package com.restaurant.repository;

import org.springframework.data.repository.CrudRepository;
import com.restaurant.entity.Top;

public interface TableRepository extends CrudRepository<Top, Long>{

  public Top findByTableId(Long tableId);
}
