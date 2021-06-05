package com.restaurant.repository;

import org.springframework.data.repository.CrudRepository;
import com.restaurant.entity.Schedule;

public interface ScheduleRepository extends CrudRepository<Schedule, Long>{

  public Schedule findByScheduleId(Long scheduleId);
}
