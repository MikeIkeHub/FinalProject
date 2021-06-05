package com.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restaurant.entity.Ticket;
import com.restaurant.repository.TicketRepository;

@Service
public class TicketService {

  @Autowired
  private TicketRepository ticketRepo;
  
//CREATE
  public Ticket addTicket(Ticket ticket) {
    return ticketRepo.save(ticket);
  }
  
//READ - RETURN ALL TICKETS
  public Iterable<Ticket> getTickets(){
    return ticketRepo.findAll();
  }
  
//READ - RETURN BY TICKET NUMBER
  public Ticket findByTicketPk(Long ticketPk) {
    return ticketRepo.findByTicketPk(ticketPk);
  }
  
//UPDATE
  public Ticket updateTicket(Ticket ticket, Long ticketPk) throws Exception {
    try {
      Ticket needsUpdateTicket = ticketRepo.findByTicketPk(ticketPk);
      needsUpdateTicket.setDrinkFK(ticket.getDrinkFK());
      needsUpdateTicket.setEmp(ticket.getEmp());
      needsUpdateTicket.setMenu(ticket.getMenu());
      needsUpdateTicket.setTable(ticket.getTable());
      return ticketRepo.save(needsUpdateTicket);
    }catch(Exception e) {
      throw new Exception("Unable to Update Ticket");
    }
  }
  
//DELETE
  public void deleteTicket(Long PK) {
    ticketRepo.deleteById(PK);
  }
}
