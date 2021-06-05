package com.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restaurant.entity.Schedule;
import com.restaurant.repository.ScheduleRepository;

@Service
public class ScheduleService {

  @Autowired
  private ScheduleRepository schedRepo;

//CREATE - Create Schedule
  public Schedule addSchedule(Schedule schedule) {
    return schedRepo.save(schedule);
  }
  
//READ - Return All Employees
  public Iterable<Schedule> getSchedules(){
    return schedRepo.findAll();
  }

//UPDATE - Updates a Schedule
  public Schedule updateSchedule(Schedule schedule, Long Id) throws Exception {
    try {
      Schedule needsUpdateSchedule = schedRepo.findByScheduleId(Id);
      needsUpdateSchedule.setScheduleId(schedule.getScheduleId());
      needsUpdateSchedule.setSchedule(schedule.getSchedule());
      return schedRepo.save(needsUpdateSchedule);
    }catch(Exception e) {
      throw new Exception("Unable to Update Schedule");
    }
  }
  
//DELETE
  public void deleteSchedule(Long PK) {
    schedRepo.deleteById(PK);
  }
}
