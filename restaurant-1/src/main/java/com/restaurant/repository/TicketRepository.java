package com.restaurant.repository;

import org.springframework.data.repository.CrudRepository;
import com.restaurant.entity.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Long> {

  public Ticket findByTicketPk(Long ticketPk);
}
