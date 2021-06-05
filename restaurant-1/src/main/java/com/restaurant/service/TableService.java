package com.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restaurant.entity.Top;
import com.restaurant.repository.TableRepository;

@Service
public class TableService {

  @Autowired
  private TableRepository tableRepo;
  
//CREATE - Create Schedule
  public Top addTable(Top table) {
    return tableRepo.save(table);
  }
  
//READ - Return All Tables
  public Iterable<Top> getTables(){
    return tableRepo.findAll();
  }
  
//UPDATE - Updates a Table
  public Top updateTable(Top table, Long Id) throws Exception {
    try {
      Top needsUpdateTable = tableRepo.findByTableId(Id);
      needsUpdateTable.setSeats(table.getSeats());
      needsUpdateTable.setSection(table.getSection());
      needsUpdateTable.setTableId(table.getTableId());
      return tableRepo.save(needsUpdateTable);
    }catch(Exception e) {
      throw new Exception("Unable to Update Table");
    }
  }
  
//DELETE - Deletes a Table
  public void deleteTable(Long PK) {
    tableRepo.deleteById(PK);
  }
}
